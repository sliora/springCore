package hello.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempApp {
    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://loawa.com").get();
            System.out.println(document.select(".today-quest-list"));

            String islandName = ".today-quest-list .island-name";
            String islandPay = ".today-quest-list .lang-text";
            String islandImg = ".today-quest-list img";

            for(int i=0; i<document.select(islandName).size(); i++) {
                System.out.println(document.select(islandName).get(i).text());
                System.out.println(document.select(islandPay).get(i).text());
                System.out.println(document.select(islandImg).get(i).absUrl("src"));
            }
        }catch (IOException ex) {

        }



    }
}
