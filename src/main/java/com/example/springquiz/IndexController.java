package com.example.springquiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	int cuenta = 0;
	int correccion = 0;
	String rCorrecta = "";
	int preguntas = 0;
	List<Integer> aux = new ArrayList<>();
	String pagina="";
	String nombre = "";
	
	@Autowired
	private preguntaDAO p;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	  public String  get_home(Model modelo) {

	    return "home";
	}	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	  public String  get_valor(Model modelo) {

		pregunta1(modelo);
	    return "index";
	}
	
	@RequestMapping(value="/index2", method=RequestMethod.GET)
	  public String  get_valor2(Model modelo) {

		pregunta2(modelo);
	    return "pregunta2";
	}
	
	@RequestMapping(value="/index3", method=RequestMethod.GET)
	  public String  get_valor3(Model modelo) {

		pregunta3(modelo);
	    return "pregunta3";
	}
	
	@RequestMapping(value="/index4", method=RequestMethod.GET)
	  public String  get_valor4(Model modelo) {

		pregunta4(modelo);
	    return "pregunta4";
	}
	
	@RequestMapping(value="/index5", method=RequestMethod.GET)
	  public String  get_valor5(Model modelo) {

		pregunta5(modelo);
	    return "pregunta5";
	}
	
	@RequestMapping(value="/index6", method=RequestMethod.GET)
	  public String  get_valor6(Model modelo) {
		
		pregunta6(modelo);
	    return "pregunta6";
	}
	
	@RequestMapping(value="/resultado", method=RequestMethod.GET)
	  public String  get_resultado(Model modelo) {

	    return "resultado";
	}
	
	
	private Model pregunta1(Model modelo) {
		modelo.addAttribute("foto", "images/chuck.jpg");
		modelo.addAttribute("pregunta1", "Pikachu");
		modelo.addAttribute("pregunta2", "Pascual");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Chuck Norris");
		return modelo;
	}
	
	private Model pregunta2(Model modelo) {
		modelo.addAttribute("foto", "images/messi.jpeg");
		modelo.addAttribute("pregunta1", "Cristiano Ronaldo");
		modelo.addAttribute("pregunta2", "Superman");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Batman");
		return modelo;
	}
	
	private Model pregunta3(Model modelo) {
		modelo.addAttribute("foto", "images/tarta.jpg");
		return modelo;
	}
	
	private Model pregunta4(Model modelo) {
		modelo.addAttribute("foto", "images/leche.jpg");
		modelo.addAttribute("pregunta1", "Vaso");
		modelo.addAttribute("pregunta2", "Leche");
		modelo.addAttribute("pregunta3", "Manos");
		modelo.addAttribute("pregunta4", "No se ve nada");
		return modelo;
	}
	
	private Model pregunta5(Model modelo) {
		modelo.addAttribute("foto", "images/pikachu.png");
		modelo.addAttribute("pregunta1", "Un ordenador");
		modelo.addAttribute("pregunta2", "Pikachu");
		modelo.addAttribute("pregunta3", "The Rock");
		modelo.addAttribute("pregunta4", "Jackie Chan");
		return modelo;
	}
	
	private Model pregunta6(Model modelo) {
		modelo.addAttribute("foto", "images/totoro.png");
		return modelo;
	}


}
