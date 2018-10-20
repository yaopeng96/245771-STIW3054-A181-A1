package com.mycompany.assignment1.main;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Read {

    public static List<Data> read() {
        try {
            //create arraylist
            List<Data> data = new ArrayList<Data>();

            //alocated website
            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();

            //alocated table in the website
            Element tgt = doc.select("table.wikitable").get(1);
            Elements trs = tgt.select("tr");

            //read data  from wikipedia
            for (Element tr : trs) {
                String c1 = tr.select("th").text();
                String c2 = tr.select("td").text();
                //add data into array list
                data.add(new Data(c1, c2));
            }
            return data;
        } catch(Exception e){
               e.printStackTrace();
               return null;
        }
    }
}
