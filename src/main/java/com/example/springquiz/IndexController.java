package com.example.springquiz;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	  public String  get_valor(Model modelo) {
		
		File carpeta = new File("src\\main\\resources\\static\\images"); 
		File[] lista = carpeta.listFiles();    
		int cuenta=0;

		  for (int i = 0; i < lista.length; i++) 
		      if (lista[i].isFile())
		           cuenta++;
		
		Random r = new Random();
		int valorDado = r.nextInt(cuenta)+1;
		
		if(valorDado == 1) {
			modelo = pregunta1(modelo);
		} else if (valorDado == 2)
			modelo = pregunta2(modelo);
		
	    return "index";
	}
	
	private Model pregunta1(Model modelo) {
		modelo.addAttribute("foto", "images/chuck.jpg");
		modelo.addAttribute("pregunta1", "Pikachu");
		modelo.addAttribute("pregunta2", "Pascual");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Chuck Norris");
		modelo.addAttribute("preguntacorrecta", "Chuck Norris");
		return modelo;
	}
	
	private Model pregunta2(Model modelo) {
		modelo.addAttribute("foto", "images/messi.jpeg");
		modelo.addAttribute("pregunta1", "Alguien");
		modelo.addAttribute("pregunta2", "No lo sé");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Batman");
		modelo.addAttribute("preguntacorrecta", "Messi");
		return modelo;
	}
	

	
	

}
