package 设计模式实验二.ex11;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Main {
}

class Photograph {
    private Filter filter;
    public void setFilter(Filter filter) {
        this.filter = filter;
    }
    public void getProcessed() {
        filter.process();
    }
}

interface Filter {
    void process();
}

class NostalgicFilter implements Filter {
    public void process() {
        System.out.println("怀旧效果");
    }
}

class BlackWhiteFilter implements Filter {
    public void process() {
        System.out.println("黑白效果");
    }

}

class MonochromaticFilter implements Filter {
    public void process() {
        System.out.println("单色效果");
    }

}