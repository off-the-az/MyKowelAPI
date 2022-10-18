package com.az.mykowel.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
public class PanelViewController {
    @GetMapping("/panel/{type}")
	public String panel(@PathVariable String type){
		if(Objects.equals(type, "m-dev-k")) return "pc/panel/panel";
		else return "modules/exceptions/fuck-u-user";
	}
}