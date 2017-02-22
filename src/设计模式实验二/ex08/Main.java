package 设计模式实验二.ex08;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/1/8 0008.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ShareSystem{
    private LinkedList<Investor> investors = new LinkedList<>();
    public void change5percent(){
        for(Investor i:investors){
            i.react();
        }
    }

    public void add(Investor investor){
        investors.add(investor);
    }
}

interface Investor{
    void react();
}

class HappyInvestor implements Investor{

    @Override
    public void react() {
        System.out.println("走!搓一顿!");
    }
}

class SadInvestor implements Investor{

    @Override
    public void react() {
        System.out.println("走!排队上天台!");
    }
}