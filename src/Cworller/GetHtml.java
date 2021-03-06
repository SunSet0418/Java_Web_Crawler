package Cworller;

import org.jsoup.Jsoup;

import java.io.IOException;


public class GetHtml {

    Logger logger = new Logger();

    private org.jsoup.nodes.Document doc;

    public org.jsoup.nodes.Document getHtml(String url) {

        doc = null;

        try {
            doc = Jsoup.connect(url).get();
        }
        catch (IOException e) {
            logger.alert(e.toString());
            e.printStackTrace();
        }

        System.out.println(doc);

        return doc;
    }

    public String getAttr(String CssSelector, String Key){

        String data = doc.select(CssSelector).attr(Key);

        System.out.println("ATTR : "+Key);
        System.out.println(data);

        return data;

    }

    public String getData(String CssSelector){

        String data = doc.select(CssSelector).text();

        return data;

    }


}
