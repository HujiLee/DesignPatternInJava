package 设计模式实验一.ex04abstractFactory;

import 设计模式实验二.ex03.XmlUtil;

/**
 * Created by Administrator on 2016/12/12 0012.
 */

interface AbstractFactory{
    Button createButton();
    Text createText();
    ComboBox createComboBox();
}
class SpringFactory implements AbstractFactory{

    @Override
    public Button createButton() {
        return new GreenButton();
    }

    @Override
    public Text createText() {
        return new GreenText();
    }

    @Override
    public ComboBox createComboBox() {
        return new GreenComboBox();
    }
}

class SummerFactory implements AbstractFactory{


    @Override
    public Button createButton() {
        return new BlueButton();
    }

    @Override
    public Text createText() {
        return new BlueText();
}

    @Override
    public ComboBox createComboBox() {
        return new BlueComboBox();
    }
}

interface Button{
    void show();
}
class GreenButton implements Button{
    @Override
    public void show() {
        System.out.println("green button show");
    }
}
class BlueButton implements Button{
    @Override
    public void show() {
        System.out.println("blue button show");
    }
}

interface Text{
    void show();
}
class GreenText implements Text{

    @Override
    public void show() {
        System.out.println("green text show");
    }
}
class BlueText implements Text{

    @Override
    public void show() {
        System.out.println("blue text show");
    }
}

interface ComboBox{
    void show();
}

class GreenComboBox implements ComboBox{
    @Override
    public void show() {
        System.out.println("green comboBox show");
    }
}

class BlueComboBox implements ComboBox{
    @Override
    public void show() {
        System.out.println("blue comboBox show");
    }
}



public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = (AbstractFactory) XmlUtil.getBean();
        Text text = factory.createText();
        Button button = factory.createButton();
        ComboBox comboBox = factory.createComboBox();
        text.show();
        button.show();
        comboBox.show();
    }
}
