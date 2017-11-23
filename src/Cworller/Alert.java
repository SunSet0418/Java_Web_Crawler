package Cworller;

import javax.swing.*;
import java.io.File;

public class Alert {
    public void log(String logMessage){
        System.out.println(logMessage);
        JFrame panel = new JFrame("오류창");
        JTextArea text = new JTextArea();
        panel.setSize(300, 200);
        text.setText(logMessage);
        text.setEditable(false);
        panel.add(text);
        panel.setVisible(true);
    }
    public void alert(String alertMessage){
        JOptionPane.showMessageDialog(null, alertMessage, "경고", JOptionPane.WARNING_MESSAGE);
    }
    public void show(String showMessage){
        JOptionPane.showMessageDialog(null, showMessage, "알림", JOptionPane.INFORMATION_MESSAGE);
    }



}
