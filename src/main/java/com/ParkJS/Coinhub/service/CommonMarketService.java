package com.ParkJS.Coinhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Service 어노테이션을 붙여줘야 SpringContext 공간에 들어간다. 이안에 인스턴스(빈)가 생성이되는 것이고 MarketController에서 Autowired를 이용해 호출이 가능하게 된다.
@Service
public class CommonMarketService {//처음에 MaretService를 그냥 클래스로 하면 마켓이 늘어날 때 마다 추가 및 수정해줘야하므로 곤란해지므로 인터페이스를 만들어 사용해준다.

    @Autowired
     MarketService bithumbMarketService; // BithumMarketService라고 있던 클래스 명을 인터페이스 명으로 바꾼다! 다른 인스턴스가 같은 메서드를 사용하기 위해서!(상속의 느낌) , bithumMarketService를 빈이라 볼 수 있다.

    @Autowired
    MarketService upbitMarketService; //여기도 UpbitMarketService에서 -> MarketService라는 인터페이스 명으로 바꿔준다!
    public double getPrice(String market, String coin){
        if(market.equals("bithumb")){
           return bithumbMarketService.getCoinCurrentPrice(coin); //여기서 이름은 다른지만 비슷한 클래스에서 내부 내용도 다르지만 메서드의 역할은 같다. 이럴 때 인터페이스를 사용한다고 이해!
        } else if(market.equals("upbit")){
           return upbitMarketService.getCoinCurrentPrice(coin);
        }
        return 0;
    }
}
