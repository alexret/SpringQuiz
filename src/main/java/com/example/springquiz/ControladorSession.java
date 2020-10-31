package com.example.springquiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorSession {
	
	
	@Autowired
	private preguntaDAO p;
	
	private int puntos;
	
	@PostMapping("/inicio")
	public String persistMessage(@RequestParam("nombre") String nombre, Model modelo, HttpServletRequest request) {
		puntos = 0;
		if (nombre.isEmpty() || nombre.isBlank() || nombre == null) {
			modelo.addAttribute("error", "Rellene el campo del nombre");
			return "home";
		}
		
		request.getSession().setAttribute("nombre", nombre);
		return "redirect:/index";
	}	
	
	
	@PostMapping("/pregunta1")
	public String pregunta1(@RequestParam String respuesta1, Model modelo, HttpServletRequest request) {
		if (request.getParameter("respuesta1").equals("Chuck Norris"))
			puntos++;
		else
			puntos--;
		return "redirect:/index2";
	}
	
	
	@PostMapping("/pregunta2")
	public String pregunta2(@RequestParam String respuesta2, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta2").equals("Messi"))
			puntos++;
		else
			puntos--;
		return "redirect:/index3";
	}
		
	@PostMapping("/pregunta3")
	public String pregunta3(@RequestParam String respuesta3, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta3").toUpperCase().equals("TARTA"))
			puntos++;
		else
			puntos--;
		return "redirect:/index4";
	}
	
	@PostMapping("/pregunta4")
	public String pregunta4(HttpServletRequest request) {
		boolean comprobar = false;
		String[] valor = request.getParameterValues("respuesta4");
		int contador = 0;
		
		for(int i = 0; i < valor.length; i++) {
			if(valor[i].equals("Vaso"))
				contador++;
			else if (valor[i].equals("Leche"))
				contador++;
			else if (valor[i].equals("Manos"))
				contador++;
		}

		if (contador == 3)
			puntos++;
		else
			puntos--;
		
		return "redirect:/index5";
	}
	
	@PostMapping("/pregunta5")
	public String pregunta5(@RequestParam String respuesta5, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta5").equals("Pikachu"))
			puntos++;
		else
			puntos--;
		return "redirect:/index6";
	}
	
	@PostMapping("/pregunta6")
	public String pregunta6(@RequestParam String respuesta6, Model modelo, HttpServletRequest request, HttpSession session) {
		
		if (request.getParameter("respuesta6").length() > 0)
			puntos++;
		else
			puntos--;
		
		if (puntos < 0)
			puntos = 0;
		
		p.save((String) session.getAttribute("nombre"), puntos);
		modelo.addAttribute("puntos", puntos);
		return "resultado";
		
	}
	
	@GetMapping(value="/clasificacion")
	public String resultado(Model modelo) {
		List<Puntuar> puntuacion = p.recogerdatos();
		modelo.addAttribute("puntuacion",puntuacion);
	return "clasificacion";
	}
	
	
	@PostMapping("/destroy")
		public String destroySession(HttpServletRequest request) {
		puntos = 0;
		request.getSession().invalidate();
		return "redirect:/home";
	}


}
