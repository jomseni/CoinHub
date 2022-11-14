package com.ParkJS.Coinhub.controller;

import com.ParkJS.Coinhub.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {
    @Autowired
//    보통 class 안에 필드를 이렇게 넣어주려면 생성자로 인스턴스를 생성해야하는데 autowired를 통해 RestController에서 보관하고 있는 인스턴스를 호출해서 사용할 수 있다 (굳이 생성자 호출 없이!) 이렇게 autowired를 통해 바로 대입해주는것을  DI라고 한다.
    private MarketService marketService;   //스프링에 생성자를 사용하는 대신 인스턴스를 만들어놓고 autowired 어노테이션을 통해서 언제든 호출해서 사용가능하게 한다.

    @GetMapping("/price") // 코인의 최근 가격 : 어떤 마켓, 어떤 코인인지의 정보가 들어간다.
    // Get요청에선 /price? martet = A & market = b 정보가 이런식으로 들어가는데 그 파라미터를 RequestParam을 사용해서 넣는다
    public double getPrice(@RequestParam String market, @RequestParam String coin){
        //마켓Service에서 메서드를 실행할 것이다(컨트롤러가 service를 이용한다.컨트롤러가 모든 요청을 할 수 없다)
        return marketService.getPrice(market,coin);

    }
}
