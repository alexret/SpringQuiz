package com.example.springquiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorSession {
	@GetMapping("/session")
	public String process(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("respuesta");
		if (messages == null) {
		messages = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		return "redirect:/index";
	}
	
	
	@PostMapping("/persistMessage")
		public String persistMessage(@RequestParam String respuesta, HttpServletRequest request) {
		
	@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute(respuesta);
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute(respuesta, messages);
		} else
			messages.add(respuesta);
		
		request.getSession().setAttribute(respuesta, messages);
		return "redirect:/index";
	}
	
	@PostMapping("/destroy")
		public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}


}
