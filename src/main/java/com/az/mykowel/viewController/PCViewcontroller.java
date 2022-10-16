package com.az.mykowel.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
public class PCViewcontroller {
    @GetMapping("/pc/{page}")
	public String pc_view(@PathVariable String page){
        String path;
        switch(page){
            case "home":
        		path = "pc/index";
                break;
            case "news":
        		path = "pc/news";
                break;
            case "events":
        		path = "pc/events";
                break;
            case "market":
        		path = "pc/market";
                break;
            case "contacts":
        		path = "pc/contacts";
                break;
            default:
                path = "pc/index";
                break;
        }
        return path;
    }
}
