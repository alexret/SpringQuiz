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
	
	@RequestMapping(value="/resultado", method=RequestMethod.GET)
	public String index(Model modelo) {
		List<Puntuacion> puntuacion = p.recogerdatos();
		modelo.addAttribute("puntuacion",puntuacion);
	return "resultado";
	}
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	  public String  get_valor(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta1(modelo);
	    return "index";
	}
	
	@RequestMapping(value="/index2", method=RequestMethod.GET)
	  public String  get_valor2(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta2(modelo);
	    return "pregunta2";
	}
	
	@RequestMapping(value="/index3", method=RequestMethod.GET)
	  public String  get_valor3(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta3(modelo);
	    return "pregunta3";
	}
	
	@RequestMapping(value="/index4", method=RequestMethod.GET)
	  public String  get_valor4(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta4(modelo);
	    return "pregunta4";
	}
	
	@RequestMapping(value="/index5", method=RequestMethod.GET)
	  public String  get_valor5(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta5(modelo);
	    return "pregunta5";
	}
	
	@RequestMapping(value="/index6", method=RequestMethod.GET)
	  public String  get_valor6(Model modelo) {
//		cuenta = 0;
//		correccion = 0;
//		rCorrecta = "";
//		preguntas = 0;
//		aux = new ArrayList<>();
//		nombre = (String) session.getAttribute("usuario");
		pregunta6(modelo);
	    return "pregunta6";
	}
	
	
	
//	@RequestMapping(value="/prueba", method=RequestMethod.POST) 
//	public String  get_siguiente(Model modelo, 
//								@RequestParam String respuesta) {
//		
//		corregirPregunta(respuesta);
//		
//		return obtenerModelo(modelo);
//	}
	
//	private String obtenerModelo(Model modelo) {
//		if (cuenta == 0) {
//			setValores();
//		}
//		
//		preguntas++;
//		
//		if (preguntas > cuenta) {
//			addPuntuacion(modelo);
//			return "prueba";
//		}
//				
//		int valorDado = obtenerValor();
//		
//		if(valorDado == 0) {
//			modelo = pregunta1(modelo);
//		} else if (valorDado == 1) 
//			modelo = pregunta2(modelo);
//		else if (valorDado == 2) 
//			modelo = pregunta3(modelo);
//		else if (valorDado == 3) 
//			modelo = pregunta4(modelo);
//		else if (valorDado == 4) 
//			modelo = pregunta5(modelo);
//		else if (valorDado == 5) 
//			modelo = pregunta6(modelo);
//		
//		return pagina;
//	}
//	
//	private int obtenerValor() {
//		Random r = new Random();
//		
//		int aux_int= r.nextInt(cuenta);
//		
//		if (aux.contains(aux_int)) {
//			
//			while (aux.contains(aux_int))
//				aux_int = r.nextInt(cuenta);
//		}
//		
//		aux.add(aux_int);
//		
//		return aux_int;
//	}
//	
//	private void setValores() {
//		File carpeta = new File("src\\main\\resources\\static\\images"); 
//		File[] lista = carpeta.listFiles();    
//		
//		for (int i = 0; i < lista.length; i++) 
//		      if (lista[i].isFile())
//		    	  cuenta++;
//	}
//	
//	
//	private void corregirPregunta(String respuesta) {
//		if (respuesta.toUpperCase().equals(rCorrecta.toUpperCase()))
//			correccion++;
//		else
//			correccion--;
//		
//		
//		if (correccion <= 0)
//			correccion = 0;
//		
//	}
//	
//	private Model addPuntuacion(Model modelo) {
//		p.save(nombre, correccion);
//		modelo.addAttribute("correccion", correccion);
//		return modelo;
//	}
	
	private Model pregunta1(Model modelo) {
		modelo.addAttribute("foto", "images/chuck.jpg");
		modelo.addAttribute("pregunta1", "Pikachu");
		modelo.addAttribute("pregunta2", "Pascual");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Chuck Norris");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Chuck Norris";
//		pagina = "index";
		return modelo;
	}
	
	private Model pregunta2(Model modelo) {
		modelo.addAttribute("foto", "images/messi.jpeg");
		modelo.addAttribute("pregunta1", "Cristiano Ronaldo");
		modelo.addAttribute("pregunta2", "Superman");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Batman");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Messi";
//		pagina = "index";
		return modelo;
	}
	
//	private Model pregunta3(Model modelo) {
//		modelo.addAttribute("foto", "images/totoro.png");
//		modelo.addAttribute("pregunta1", "Totoro");
//		modelo.addAttribute("pregunta2", "Hulk");
//		modelo.addAttribute("pregunta3", "Charmander");
//		modelo.addAttribute("pregunta4", "Bill Gates");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Totoro";
//		pagina = "index";
//		return modelo;
//	}
//	

	
	private Model pregunta3(Model modelo) {
		modelo.addAttribute("foto", "images/tarta.jpg");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Tarta";
//		pagina = "preguntatext";
		return modelo;
	}
	
	private Model pregunta4(Model modelo) {
		modelo.addAttribute("foto", "images/leche.jpg");
		modelo.addAttribute("pregunta1", "Vaso");
		modelo.addAttribute("pregunta2", "Leche");
		modelo.addAttribute("pregunta3", "Manos");
		modelo.addAttribute("pregunta4", "No se ve nada");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Vaso, Leche, Manos";
//		pagina = "preguntacheck";
		return modelo;
	}
	
	private Model pregunta5(Model modelo) {
		modelo.addAttribute("foto", "images/pikachu.png");
		modelo.addAttribute("pregunta1", "Un ordenador");
		modelo.addAttribute("pregunta2", "Pikachu");
		modelo.addAttribute("pregunta3", "The Rock");
		modelo.addAttribute("pregunta4", "Jackie Chan");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Pikachu";
//		pagina = "index";
		return modelo;
	}
	
	private Model pregunta6(Model modelo) {
		modelo.addAttribute("foto", "images/totoro.png");
//		modelo.addAttribute("correccion", correccion);
//		rCorrecta = "Pikachu";
//		pagina = "index";
		return modelo;
	}


}
