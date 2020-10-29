package com.example.springquiz;

public class Puntuacion {
	
	private String nombre;
	private int puntuacion;
	
	public Puntuacion(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}

}
