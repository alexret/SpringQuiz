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
	public String persistMessage0(@RequestParam("usuario") String usuario, Model modelo, HttpServletRequest request) {
		puntos = 0;
		if (usuario.isEmpty() || usuario.isBlank() || usuario == null) {
			modelo.addAttribute("error", "Rellene el campo del nombre");
			return "home";
		}
		
		request.getSession().setAttribute("usuario", usuario);
		return "redirect:/index";
	}	
	
	
	@PostMapping("/pregunta1")
	public String pregunta1(@RequestParam String respuesta1, Model modelo, HttpServletRequest request) {
		if (request.getParameter("respuesta1") == "Chuck Norris")
			puntos++;
		else
			puntos--;
		return "redirect:/index2";
	}
	
	
	@PostMapping("/pregunta2")
	public String pregunta2(@RequestParam String respuesta2, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta2") == "Messi")
			puntos++;
		else
			puntos--;
		return "redirect:/index3";
	}
	
	@PostMapping("/pregunta3")
	public String pregunta3(@RequestParam String respuesta3, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta3").toUpperCase() == "TARTA")
			puntos++;
		else
			puntos--;
		return "redirect:/index4";
	}
	
	@PostMapping("/pregunta4")
	public String pregunta4(@RequestParam String respuesta4, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta4") == "Vaso, Leche, Manos")
			puntos++;
		else
			puntos--;
		return "redirect:/index5";
	}
	
	@PostMapping("/pregunta5")
	public String pregunta5(@RequestParam String respuesta5, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta5") == "Pikachu")
			puntos++;
		else
			puntos--;
		return "redirect:/index6";
	}
	
	@PostMapping("/pregunta6")
	public void pregunta6(@RequestParam String respuesta6, Model modelo, HttpServletRequest request) {
		
		if (request.getParameter("respuesta6").length() > 0)
			puntos++;
		else
			puntos--;
		resultado(modelo, request);
	}
	
	
	private String resultado(Model modelo, HttpServletRequest session) {
		
		modelo.addAttribute("puntuacion", puntos);
		String nombre = (String) session.getAttribute("usuario");
		p.save(nombre, puntos);
		
		return "resultado";
	}
	
	@PostMapping("/destroy")
		public String destroySession(HttpServletRequest request) {
		puntos = 0;
		request.getSession().invalidate();
		return "redirect:/home";
	}


}
