package com.example.springquiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	int pagina = 0;
	List<Integer> aux = new ArrayList<>();
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	  public String  get_valor(Model modelo) {
	    return obtenerModelo(modelo);
	}
	
	@RequestMapping(value="/prueba", method=RequestMethod.POST) 
	public String  get_siguiente(Model modelo, 
								@RequestParam String respuesta) {
		
		corregirPregunta(respuesta);
		
		return obtenerModelo(modelo);
	}
	
	private String obtenerModelo(Model modelo) {
		if (cuenta == 0) {
			setValores();
		}
		
		pagina++;
		
		if (pagina > cuenta) {
			addPuntuacion(modelo);
			return "prueba";
		}
				
		int valorDado = obtenerValor();
		
		if(valorDado == 0) {
			modelo = pregunta1(modelo);
		} else if (valorDado == 1) 
			modelo = pregunta2(modelo);
		else if (valorDado == 2) 
			modelo = pregunta3(modelo);
		else if (valorDado == 3) 
			modelo = pregunta4(modelo);
		
		return "index";
	}
	
	private int obtenerValor() {
		Random r = new Random();
		
		int aux_int= r.nextInt(cuenta);
		
		if (aux.contains(aux_int)) {
			
			while (aux.contains(aux_int))
				aux_int = r.nextInt(cuenta);
		}
		
		aux.add(aux_int);
		
		return aux_int;
	}
	
	private void setValores() {
		File carpeta = new File("src\\main\\resources\\static\\images"); 
		File[] lista = carpeta.listFiles();    
		
		for (int i = 0; i < lista.length; i++) 
		      if (lista[i].isFile())
		    	  cuenta++;
	}
	
	
	private void corregirPregunta(String respuesta) {
		if (respuesta.equals(rCorrecta))
			correccion++;
		else
			correccion--;
		
		
		if (correccion <= 0)
			correccion = 0;
		
	}
	
	private Model addPuntuacion(Model modelo) {
		modelo.addAttribute("correccion", correccion);
		return modelo;
	}
	
	private Model pregunta1(Model modelo) {
		modelo.addAttribute("foto", "images/chuck.jpg");
		modelo.addAttribute("pregunta1", "Pikachu");
		modelo.addAttribute("pregunta2", "Pascual");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Chuck Norris");
		modelo.addAttribute("correccion", correccion);
		rCorrecta = "Chuck Norris";
		return modelo;
	}
	
	private Model pregunta2(Model modelo) {
		modelo.addAttribute("foto", "images/messi.jpeg");
		modelo.addAttribute("pregunta1", "Cristiano Ronaldo");
		modelo.addAttribute("pregunta2", "Superman");
		modelo.addAttribute("pregunta3", "Messi");
		modelo.addAttribute("pregunta4", "Batman");
		modelo.addAttribute("correccion", correccion);
		rCorrecta = "Messi";
		return modelo;
	}
	
	private Model pregunta3(Model modelo) {
		modelo.addAttribute("foto", "images/totoro.png");
		modelo.addAttribute("pregunta1", "Totoro");
		modelo.addAttribute("pregunta2", "Hulk");
		modelo.addAttribute("pregunta3", "Charmander");
		modelo.addAttribute("pregunta4", "Bill Gates");
		modelo.addAttribute("correccion", correccion);
		rCorrecta = "Totoro";
		return modelo;
	}
	
	private Model pregunta4(Model modelo) {
		modelo.addAttribute("foto", "images/pikachu.png");
		modelo.addAttribute("pregunta1", "Un ordenador");
		modelo.addAttribute("pregunta2", "Pikachu");
		modelo.addAttribute("pregunta3", "The Rock");
		modelo.addAttribute("pregunta4", "Jackie Chan");
		modelo.addAttribute("correccion", correccion);
		rCorrecta = "Pikachu";
		return modelo;
	}
	

	
	

}
