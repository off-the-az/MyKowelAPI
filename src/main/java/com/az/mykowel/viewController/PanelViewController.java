package com.az.mykowel.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PanelViewController {
    @GetMapping("/panel")
	public String panel(){
		return "pc/panel/panel";
	}
}