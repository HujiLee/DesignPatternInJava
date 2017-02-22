package 设计模式实验二.ex04;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
interface QueryInfo{
    String getInfo(User user);
}

class RealQuery implements QueryInfo{

    @Override
    public String getInfo(User user) {
        return String.format("[Info:%s]","商务信息云云");
    }

}

class QueryProxy implements QueryInfo{
    private RealQuery realQuery = new RealQuery();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public String getInfo(User user) {
        if(null!=user&&user.isValidUser){
            System.out.printf("数据被访问,扣费一次[访问者:%s,时间:%s]\n",user,simpleDateFormat.format(new Date()));
            return realQuery.getInfo(user);
        }else {
            System.err.printf("不是有效用户,拒绝访问数据[访问者:%s,时间:%s]\n",user,simpleDateFormat.format(new Date()));
            return "{拒绝访问}";
        }
    }
}

class User{
    public final boolean isValidUser;
    public final String userName;

    User(boolean isValidUser, String userName) {
        this.isValidUser = isValidUser;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format("<user:%s>",userName);
    }
}


public class Client {
    public static void main(String[] args) {
        QueryInfo queryInfo;
//        queryInfo = new QueryProxy();
        queryInfo = (QueryInfo) XmlUtil.getBean();
        System.out.println(queryInfo.getInfo(new User(false,"unhappy")));
        System.out.println(queryInfo.getInfo(new User(true,"happyDay")));
    }


}
class XmlUtil {
    public static Object getBean() {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("config.xml"));
            NodeList nodeList = document.getElementsByTagName("className");
            Node className = nodeList.item(0).getFirstChild();
            String cName = className.getNodeValue().trim();
            Class c = Class.forName(cName);
            Object object = c.newInstance();
            return object;
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }

    }
}