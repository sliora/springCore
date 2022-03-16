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
            //System.out.println(document);
            //System.out.println(document.select("script"));
            //System.out.println(document.select("div.chr_area li.level").get(0).text());
            System.out.println(document.select(".today-quest-list"));

            String islandName = ".today-quest-list .island-name";
            String islandPay = ".today-quest-list .lang-text";
            String islandImg = ".today-quest-list img";

            for(int i=0; i<document.select(islandName).size(); i++) {
                System.out.println(document.select(islandName).get(i).text());
                System.out.println(document.select(islandPay).get(i).text());
                System.out.println(document.select(islandImg).get(i).absUrl("src"));

                //카카오 정보 넣으면 됨.
                /*

                try
                {
                Kakao.sendLink(room, {
                  "link_ver":"4.0",
                  "template_id":34062,
                  "template_args":{
                  image: document.select(islandImg).get(i).absUrl("src"),
                  title: "[보상] "+document.select(islandPay).get(i).text()
                  }
                  }, "custom");
                }
                catch(e)
                {
                    replier.reply(e)
                    //replier.reply("세션이 만료되어 카카오링크를 Reload 합니다.\n잠시후 이용해주세요.")
                    //Api.reload();
                }

                 */
            }
        }catch (IOException ex) {

        }



    }
}
