package Cworller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameClass extends JFrame {
    JTextArea input = new JTextArea("https://www.naver.com");
    JTextArea result = new JTextArea();
    JButton btn = new JButton("파싱");
    JScrollPane show = new JScrollPane(result);
    GetHtml code = new GetHtml();
    FrameClass(String name){
        Default(name);
        setLayout(new BorderLayout());
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(code.getHtml(input.getText()).toString());
            }
        });
        result.setEditable(false);
        add(input,BorderLayout.NORTH);
        add(btn, BorderLayout.SOUTH);
        add(show, BorderLayout.CENTER);
        setVisible(true);
    }
    private void Default(String Title){
        setTitle(Title);
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
