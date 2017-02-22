package 设计模式实验二.ex06;

import javax.smartcardio.CommandAPDU;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Switch {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    void turnOn() {
        command.on();
    }

    void turnOff() {
        command.off();
    }
}

interface Command {
    void on();

    void off();
}

class FanCommand implements Command {

    private Fan fan = new Fan();

    @Override
    public void on() {
        fan.on();
    }

    @Override
    public void off() {
        fan.off();
    }
}

class LightCommand implements Command {
    private Light light = new Light();

    @Override
    public void on() {
        light.on();
    }

    @Override
    public void off() {
        light.off();
    }
}

class Light {
    void on() {
        System.out.println("开灯");
    }

    void off() {
        System.out.println("关灯");
    }
}

class Fan {
    void on() {
        System.out.println("开风扇");
    }

    void off() {
        System.out.println("关风扇");
    }
}