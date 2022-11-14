package com.ParkJS.Coinhub.service;

import org.springframework.stereotype.Service;


//Service 어노테이션을 붙여줘야 SpringContext 공간에 들어간다. 이안에 인스턴스가 생성이되는 것이고 MarketController에서 Autowired를 이용해 호출이 가능하게 된다.
@Service
public class MarketService {
    public double getPrice(String market, String coin){
        return 123.444;
    }
}
