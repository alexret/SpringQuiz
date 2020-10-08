package com.example.springquiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	  public String hola(Model modelo) {
	    
	    
	    modelo.addAttribute("mensaje","hola desde thymeleaf");
	    return "index";
	}

}
