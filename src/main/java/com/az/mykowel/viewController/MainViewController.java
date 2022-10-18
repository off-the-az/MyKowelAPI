package com.az.mykowel.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
public class MainViewController {
    @GetMapping("")
	public String main(){
		return "index";
	}
}
