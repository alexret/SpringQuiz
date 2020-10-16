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
	List<Integer> numeros = new ArrayList<>();
	int correccion = 0;
	String rCorrecta = "";
	
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
		if (cuenta == 0)
			setValores();
		
		int valorDado = obtenerValor();
		
		if(valorDado == 0) {
			modelo = pregunta1(modelo);
		} else if (valorDado == 1) 
			modelo = pregunta2(modelo);
		else 
			return "prueba";
		
		numeros.remove(valorDado);
		
		return "index";
	}
	
	private int obtenerValor() {
		Random r = new Random();
		if (numeros.size()==0)
			return -1;
		return r.nextInt(numeros.size());
	}
	
	private void setValores() {
		File carpeta = new File("src\\main\\resources\\static\\images"); 
		File[] lista = carpeta.listFiles();    

		for (int i = 0; i < lista.length; i++) 
		      if (lista[i].isFile())
		    	  numeros.add(++cuenta);
				
	}
	
	private void corregirPregunta(String respuesta) {
		if (respuesta.equals(rCorrecta))
			correccion = correccion + 1;
		else
			correccion = correccion - 1;
		
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
	

	
	

}
