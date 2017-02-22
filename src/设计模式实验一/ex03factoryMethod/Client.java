package 设计模式实验一.ex03factoryMethod;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
interface ImageReader {
    void readImage(String img);
}

class GifReader implements ImageReader {

    @Override
    public void readImage(String img) {
        System.out.println("reading gif file:" + img);
    }
}

class JpgReader implements ImageReader {

    @Override
    public void readImage(String img) {
        System.out.println("reading jpg file:" + img);
    }

}

interface ImageReaderFactory {
    ImageReader createReader();
}

class GifReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createReader() {
        return new GifReader();
    }
}

class JpgReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createReader() {
        return new JpgReader();
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

public class Client {
    public static void main(String[] args) {
        ImageReaderFactory factory = (ImageReaderFactory) XmlUtil.getBean();
        ImageReader reader = factory.createReader();
        reader.readImage("img.txt");

    }

}
