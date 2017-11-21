package Cworller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
                String html = code.getHtml(input.getText()).toString();
                result.setText(html);
                try
                {
                    FileWriter fw = new FileWriter("out.html"); // 절대주소 경로 가능
                    BufferedWriter bw = new BufferedWriter(fw);
                    String str = html;

                    bw.write(str);
                    bw.newLine(); // 줄바꿈

                    bw.close();
                }
                catch (IOException er)
                {
                    System.err.println(er); // 에러가 있다면 메시지 출력
                    System.exit(1);
                }
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
