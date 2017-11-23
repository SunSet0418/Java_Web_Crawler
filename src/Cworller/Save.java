package Cworller;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    Alert alert = new Alert();

    public void saver(String data){
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(frame);
        String returnvalue = "asdf";
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try
            {
                FileWriter fw = new FileWriter(f); // 절대주소 경로 가능
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(data);
                bw.newLine(); // 줄바꿈
                bw.close();
            }
            catch (IOException er)
            {
                alert.log(er.toString()); // 에러가 있다면 메시지 출력
            }
            System.out.println("Save as file: " + f.getAbsolutePath());
            if(userSelection == 0){
                returnvalue = f.getAbsolutePath();
                alert.show(returnvalue+"에 저장되었습니다");
            }

        }
    }
}
