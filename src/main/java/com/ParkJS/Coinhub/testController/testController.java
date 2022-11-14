package com.ParkJS.Coinhub.testController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/")
    public String test(){
        return "start_topic_Coinhub";
    }
}
