<<<<<<< HEAD
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
=======
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
>>>>>>> b11b88f (v. 0.1.11-2)
