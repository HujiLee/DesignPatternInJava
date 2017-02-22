package 设计模式实验一.ex06Singleton.prepare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame simpleFrame = new SimpleFrame();
                simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                simpleFrame.setVisible(true);
                simpleFrame.setTitle("Simple 的 Frame");
            }
        });

    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Click me");

    public SimpleFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(panel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4,4));
        jPanel.add(button,BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleInner inner = SimpleInner.getInstance();
                panel.add(inner);
                inner.show();
            }
        });

        this.add(jPanel);
    }
}

class SimpleInner extends JInternalFrame{
    static private SimpleInner singleton = new SimpleInner();
    public static SimpleInner getInstance(){
        return singleton;
    }
    private SimpleInner(){
        setSize(400,500);
        setTitle("Inner Window"+233);
    }
}

