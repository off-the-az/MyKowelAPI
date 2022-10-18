package com.az.mykowel.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
public class MobileViewController {
    @GetMapping("/mobile")
	public String mobile_view(@PathVariable String page){
        String path;
        switch(page){
            case "home":
        		path = "mobile/index";
                break;
            case "news":
        		path = "mobile/news";
                break;
            case "events":
        		path = "mobile/events";
                break;
            case "market":
        		path = "mobile/market";
                break;
            case "contacts":
        		path = "mobile/contacts";
                break;
            default:
                path = "mobile/index";
                break;
        }
        return path;
    }
}