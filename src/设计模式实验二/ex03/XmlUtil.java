package 设计模式实验二.ex03;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlUtil {
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

