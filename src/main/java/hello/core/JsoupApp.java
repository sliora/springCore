package hello.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupApp {
    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/히도링").get();
            //System.out.println(document);
            //System.out.println(document.select("script"));
            //System.out.println(document.select("div.chr_area li.level").get(0).text());
            //System.out.println(document);
            System.out.println(document.select(".level-info2__item").text());
            System.out.println(document.select(".level-info__item").text());
            System.out.println(document.select(".level-info__expedition").text());
            System.out.println(document.select(".profile-character-info__server").text());
            System.out.println(document.select(".game-info__guild").text());
            System.out.println(document.select(".profile-skill__point").text());
            List<String> list = new ArrayList<>();
            for (Element i: document.select(".profile-ability-battle span").next("span")) {

                list.add(i.text());
            }
            System.out.println("치명 : " + list.get(0));
            System.out.println("특화 : " + list.get(1));
            System.out.println("신속 : " + list.get(3));


            System.out.println("각인 : " + document.select(".profile-ability-engrave span").text().replace("Lv. ",""));
            System.out.println("공격력/체력 : " + document.select(".profile-ability-basic span").next("span").text().replace(" ","/").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","));
            System.out.println("카드 : " + document.select(".card-effect__title").last().text());
            //System.out.println("카드 : " + document.getElementsByTag("script").next("qualityValue"));
            System.out.println("이미지 : " + document.select(".profile-equipment__character img").get(0).absUrl("src"));

           for (Element element : document.getElementsByTag("script")) {
                System.out.println(element.attr("","qualityValue"));
            }





        }catch (IOException ex) {

        }



    }
}
