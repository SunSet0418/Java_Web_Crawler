package Cworller;

import javax.swing.*;
import java.util.ArrayList;

public class Logger extends Alert{
    ArrayList<String> data = new ArrayList<>();
    int i = 1;

    public void save(String url){
        System.out.println(data.size());
        data.add(i+" : "+url);
        i++;
        System.out.println(data);
    }

    public void list(){
        if(data.size() == 0){
            alert("검색기록 없음");
        }
        else{
            JFrame panel = new JFrame("검색 기록");
            String[] array = new String[data.size()];
            data.toArray(array);
            JList<String> list = new JList<>(array);
            panel.setSize(300, 300);
            panel.add(list);
            panel.setVisible(true);
        }

    }
}
