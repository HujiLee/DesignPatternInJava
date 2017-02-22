package 设计模式实验二.ex07;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class BoardScreen {

    private Menu menu = new Menu();
    public void create() {
        System.out.println("新建...");
    }

    public void open() {
        System.out.println("打开...");
    }

    public void edit() {
        System.out.println("编辑...");
    }

}

class Menu {
    private LinkedList<MenuItem> items = new LinkedList<>();
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

}

class MenuItem {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }

}

interface Command {

    void execute();

}

class CreateCommand implements Command {

    private BoardScreen bScreen;

    public CreateCommand(BoardScreen bScreen) {
        this.bScreen = bScreen;
    }

    public void execute() {
        bScreen.create();
    }

}

class OpenCommand implements Command {

    private BoardScreen bScreen;


    public OpenCommand(BoardScreen bScreen) {
        this.bScreen = bScreen;
    }

    public void execute() {
        bScreen.open();
    }

}

class EditCommand implements Command {

    private BoardScreen bScreen;

    public EditCommand(BoardScreen bScreen) {
        this.bScreen = bScreen;
    }

    public void execute() {
        bScreen.edit();
    }

}