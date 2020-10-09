package com.example.springquiz;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	  public String  get_valor(Model modelo) {
		
	    		    	
	    return "index";
	}
	
	

}
