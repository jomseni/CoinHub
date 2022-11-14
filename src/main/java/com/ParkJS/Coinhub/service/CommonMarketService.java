package com.ParkJS.Coinhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;


//Service 어노테이션을 붙여줘야 SpringContext 공간에 들어간다. 이안에 인스턴스(빈)가 생성이되는 것이고 MarketController에서 Autowired를 이용해 호출이 가능하게 된다.
@Service
public class CommonMarketService {//처음에 MaretService를 그냥 클래스로 하면 마켓이 늘어날 때 마다 추가 및 수정해줘야하므로 곤란해지므로 인터페이스를 만들어 사용해준다.

    @Autowired
//    List<MarketService> marketServices; // MarketService라는 인터페이스를 가진 것들을 모두 불러온다 ,MarketService는 곧 market의 클래스명들과 같다!ex ) BithumbMarketService, UpbitMarketService..등등
    Map<String, MarketService> marketServices; //MarketService라는 인터페이스를 가진 것들을 모두(클래스) 불러오는데 어떻게 불러오냐면 String은 키값이고 그 키값은 빈(인스턴스)의 이름이 들어온다! 즉 bitthumb,upbit 등등..

    public double getPrice(String market, String coin) {

        MarketService marketService = null;

        //marketServices들의 key값을 모두 불러와서 반복문을 돌리고 (key값은 market의 이름 즉, 인스턴스(빈)의 이름)
        for (String key : marketServices.keySet()) {
        //그 키 값의 앞에 market 이름 길이 만큼 짤라와서 비교! 그리고 검색하는 부분(사용자가 입력부분)market= 어쩌구저쩌구에 어쩌구 저쩌구를 모두 소문자로 바꾼것과 같으면 True => if문 진행
            if (key.substring(0, market.length()).equals(market.toLowerCase())) { //빈의 이름에서 앞을 자른다.
                marketService = marketServices.get(key);
                break;
            }
        }
        return marketService.getCoinCurrentPrice(coin);
    }
//        이 전의 if문 방법은 안좋으므로 삭제한다

}
