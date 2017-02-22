package 设计模式实验二.ex03;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
interface Subject {
    boolean call();
}

class RealSubject implements Subject {

    @Override
    public boolean call() {
        int ram = (int) (Math.random() * 100);
        System.out.println("生成随机数:" + ram);
        switch (ram % 2) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return false;
        }

    }
}

class LogProxy implements Subject {
    private RealSubject realSubject = new RealSubject();

    @Override
    public boolean call() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("call 方法被调用:" + simpleDateFormat.format(new Date()));
        if(realSubject.call()){
            System.out.println("调用成功,生成了一个偶数");
            return true;

        }else{
            System.out.println("调用失败,生成了一个奇数");
            return false;
        }

    }
}


public class Main {
    public static void main(String[] args) {
        Subject subject = new LogProxy();
        subject.call();

    }
}
