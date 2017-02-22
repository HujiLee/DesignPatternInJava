package 设计模式实验二.ex09;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Thermosensor {
    private LinkedList<Alarmer> alarmers = new LinkedList<>();

    public void itIsHot() {
        for (Alarmer alarmer : alarmers) {
            alarmer.alarm();
        }
    }

    public void addAlarmer(Alarmer alarmer) {
        alarmers.add(alarmer);
    }

}

interface Alarmer {
    void alarm();
}

class CautionLightAlarmer implements Alarmer {
    CautionLight cautionLight = new CautionLight();

    public void alarm() {
        cautionLight.flicker();
    }
}

class CautionLight {
    public int flicker() {
        System.out.println("警示灯闪烁!");
        return 0;
    }
}

class SecurityDoorAlarmer implements Alarmer {
    SecurityDoor securityDoor = new SecurityDoor();

    public void alarm() {
        securityDoor.open();
    }

}

class SecurityDoor {
    public int open() {
        System.out.println("安全逃生门自动打开!");
        return 0;
    }
}

class AnnunciatorAlarmer implements Alarmer {
    Annunciator annunciator = new Annunciator();

    public void alarm() {
        annunciator.alarm();
    }

}

class Annunciator {

    public int alarm() {
        System.out.println("报警器发出警报!");
        return 0;
    }
}

class InsulatedDoorAlarmer implements Alarmer {
    InsulatedDoor insulatedDoor = new InsulatedDoor();


    public void alarm() {
        insulatedDoor.close();
    }

}

class InsulatedDoor {
    public int close() {
        System.out.println("隔热门自动关闭!");
        return 0;
    }

}