package 设计模式实验二.ex05;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

class Order {
    public final int money;
    public final String buyWhat;

    Order(int money, String buyWhat) {
        this.money = money;
        this.buyWhat = buyWhat;
    }

    @Override
    public String toString() {
        return String.format("[buy:%s,need:%d万人民币]",buyWhat,money);
    }
}

abstract class Leader {
    protected String name;
    private Leader next;

    public Leader setNext(Leader leader) {
        this.next = leader;
        return this.next;
    }

    public Leader getNext() {
        return next;
    }

    public abstract boolean approve(Order order);
}

class Zhuren extends Leader {
    public Zhuren(String name) {
        this.name = name;
    }

    @Override
    public boolean approve(Order order) {
        if (order.money < 5) {
            System.out.printf("主任批准了%s\n", order);
            return true;
        } else {
            System.out.printf("主任拿不准%s\n", order);
            return this.getNext().approve(order);
        }
    }
}

class FuDong extends Leader {
    public FuDong(String name) {
        this.name = name;
    }

    @Override
    public boolean approve(Order order) {

        if (order.money < 10) {
            System.out.printf("副董事长批准了%s\n", order);
            return true;
        } else {
            System.out.printf("副董事长拿不准%s\n", order);
            return this.getNext().approve(order);
        }
    }
}

class Dongshizhang extends Leader {
    public Dongshizhang(String name) {
        this.name = name;
    }

    @Override
    public boolean approve(Order order) {
        if (order.money < 50) {
            System.out.printf("董事长批准了%s\n", order);
            return true;
        } else {
            System.out.printf("董事长拿不准%s\n", order);
            return this.getNext().approve(order);
        }

    }
}

class Dongshihui extends Leader {

    public Dongshihui() {
        this.name="董事会";
    }

    @Override
    public boolean approve(Order order) {
        if (String.valueOf(order.money).contains("4")) {
            System.out.printf("数字不吉利,董事会拒绝批准%s\n", order);
            return false;
        } else {
            System.out.printf("董事会批准了%s\n", order);
            return true;
        }

    }
}


public class Client {
    public static void main(String[] args) {
        Leader chainHead = new Zhuren("刘主任");
        chainHead.setNext(new FuDong("王副董事")).setNext(new Dongshizhang("李董事长")).setNext(new Dongshihui());
        chainHead.approve(new Order(4, "办公文具"));
        chainHead.approve(new Order(20, "苹果电脑"));
        chainHead.approve(new Order(444, "电梯"));
    }
}
