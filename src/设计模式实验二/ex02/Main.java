package 设计模式实验二.ex02;

/**
 * Created by Administrator on 2017/1/8 0008.
 */
public class Main {
    public static void main(String[] args) {

    }
}

abstract class Facade {
    public abstract void process();
}

class Facade4NotXml extends Facade {
    private Reader reader = new Reader();
    private Analysis analysis = new Analysis();
    private Report report = new Report();

    @Override
    public void process() {
        reader.read();
        analysis.analyse();
        report.show();
    }
}

class Facade4Xml extends Facade {
    private Reader reader = new Reader();
    private Transformer transformer = new Transformer();
    private Analysis analysis = new Analysis();
    private Report report = new Report();

    @Override
    public void process() {

    }
}

class Reader {
    void read() {
        System.out.println("读取文件数据");
    }
}

class Analysis {
    void analyse() {
        System.out.println("统计分析数据");
    }
}

class Report {
    void show() {
        System.out.println("报表显示");
    }
}

class Transformer {
    void toXml() {
        System.out.println("准换成XML数据");
    }
}