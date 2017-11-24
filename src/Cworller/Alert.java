package Cworller;

import javax.swing.*;
import java.io.File;

public class Alert {
    public void alert(String alertMessage){
        JOptionPane.showMessageDialog(null, alertMessage, "경고", JOptionPane.WARNING_MESSAGE);
    }
    public void show(String showMessage){
        JOptionPane.showMessageDialog(null, showMessage, "알림", JOptionPane.INFORMATION_MESSAGE);
    }
}
