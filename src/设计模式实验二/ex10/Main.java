package 设计模式实验二.ex10;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MovieTicket {
    private double originalPrice;
    private Discount discount;

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getRealPrice() {
        if (discount == null) {
            return originalPrice;
        } else {
            return discount.clacPrice(originalPrice);
        }
    }

}

interface Discount {
    double clacPrice(double originalPrice);
}

class ChildDiscount implements Discount {

    public double clacPrice(double originalPrice) {
        if (originalPrice >= 20) {
            return originalPrice - 10;
        } else {
            return originalPrice;
        }
    }

}

class StudentDiscount implements Discount {

    public double clacPrice(double originalPrice) {
        return originalPrice * 0.8;
    }
}

class VipDiscount implements Discount {

    public double clacPrice(double originalPrice) {
        System.out.println("积分+1s");
        return originalPrice * 0.5;
    }

}
