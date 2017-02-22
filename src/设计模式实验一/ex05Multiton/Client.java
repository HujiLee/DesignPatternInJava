package 设计模式实验一.ex05Multiton;

/**
 * Created by Administrator on 2016/12/12 0012.
 */

class Multi{
   private static Multi[] multis=new Multi[2];
   public static Multi getInstance(){
        if(multis[0]==null){
            multis[0]=new Multi(1);
            return multis[0];
        }else if(multis[1]==null) {
            multis[1] = new Multi(2);
            return multis[1];
        }
        else {
            //随机返回两个中的一个
            int randNum = (int) (Math.random()*10)%2;
            return multis[randNum];
        }
    }
    private int NO;
    private Multi(int no){
       this.NO = no;
    }

    @Override
    public String toString() {
        return String.format("[%s]:%d",this.getClass(),this.NO);
    }
}


public class Client {
    public static void main(String[] args) {
        for(int i:new int[9]){
            System.out.println(Multi.getInstance());
        }

    }
}
