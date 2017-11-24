package Cworller;

import org.jsoup.Jsoup;

import java.io.IOException;

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

    Logger logger = new Logger();
    public org.jsoup.nodes.Document getHtml(String url) {
        org.jsoup.nodes.Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.alert(e.toString());
            e.printStackTrace();
        }
        System.out.println(doc);
        return doc;
    }
}
