package hello.core;

import org.json.JSONArray;
import org.json.JSONObject;
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
            Document document = Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/히도링").ignoreContentType(true).get();
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
/*            for (Element i: document.select(".profile-ability-battle span").next("span")) {

                list.add(i.text());
            }
            */
            for(int i=0; i<document.select(".profile-ability-battle span").next("span").size(); i++) {
                list.add(document.select(".profile-ability-battle span").next("span").get(i).text());
            }


            System.out.println("치명 : " + list.get(0));
            System.out.println("특화 : " + list.get(1));
            System.out.println("신속 : " + list.get(3));


            System.out.println("각인 : " + document.select(".profile-ability-engrave span").text().replace("Lv. ",""));
            System.out.println("공격력/체력 : " + document.select(".profile-ability-basic span").next("span").text().replace(" ","/").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","));
            System.out.println("카드 : " + document.select(".card-effect__title").last().text());
            //System.out.println("카드 : " + document.getElementsByTag("script").next("qualityValue"));
            System.out.println("이미지 : " + document.select(".profile-equipment__character img").get(0).absUrl("src"));

            System.out.println("참고 : " + document.text());

            //JSON.parse(document) 해보기

/*           for (Element element : document.getElementsByTag("script")) {
                System.out.println(element.attr("","qualityValue"));
            }*/

/*            JSONArray jArray = new JSONArray(document.select("script"));

            JSONObject jObeject = new JSONObject(document.select("script"));

            System.out.println(jObeject);
            System.out.println(jArray);*/
/*
* importClass(org.jsoup.Jsoup);

const responseRoom=['방1','방2'];  //내용을 출력 할 방 이름

const mention=['@뀨야','뀨야님 '];  //인식 할 단어



function response(r, m, s, _, re){

if(mention.some(e=>m.includes(e))){

    try{

        let a=Jsoup.connect('https://open.kakao.com/c/search/unified?q='+encodeURIComponent(r)).ignoreContentType(true).post().text();

        let rData=JSON.parse(a);

        let callUrl=rData.items[0].lu;

        for(let i=0; i<responseRoom.length; i++){

            re.reply(responseRoom[i],[

            "[ 호출 ]",

            '- 닉네임 : '+s,

            '- 내용 : '+m,

            '- 방이름 : '+r,

            _?('- URL : '+callUrl):'※ 1:1채팅방에서 발송됨'

            ].map(e=>e).join('\n'));

        }

    } catch(e){

        for(let i=0; i<responseRoom.length; i++){

        re.reply(responseRoom[i],[

            "[ 호출 ]",

            '- 닉네임 : '+s,

            '- 내용 : '+m,

            '- 방이름 : '+r,

            '※ 그룹채팅방에서 발송됨'

            ].map(e=>e).join('\n'));

        }

    }

}

}
[출처] 특정단어 언급 시 특정방에 뿌리기 (카카오톡 봇 커뮤니티) | 작성자 뀨야
*
*
* room1 = ["방이름"];


if (sender.startsWith("이름")) {

var mesage = msg.substr(4)

replier.reply(room1, "["+sender+"] 왈\n "+mesage)

}
* */




        }catch (IOException ex) {

        }



    }
}
