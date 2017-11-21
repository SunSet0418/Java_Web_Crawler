package Cworller;

import org.jsoup.Jsoup;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.sun.activation.registries.LogSupport.log;

public class GetHtml {
//    public static ArrayList<String> getSource(String url) throws MalformedURLException, IOException {
//        ArrayList<String> output = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(),"utf-8"));
//        String line;
//        while ((line = br.readLine()) != null) {
//            output.add(line);
//        }
//        return output;
//    }

    LoggerClass logger = new LoggerClass();
    public org.jsoup.nodes.Document getHtml(String url) {
        org.jsoup.nodes.Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc);
        return doc;
    }
}
