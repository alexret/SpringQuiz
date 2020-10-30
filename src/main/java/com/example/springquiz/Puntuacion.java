package com.example.springquiz;

public class Puntuacion {
	
	private String nombre;
	private int puntuacion;
	
	public Puntuacion(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public String getNombre(String nombre) {
		return this.nombre;
	}


	public int getPuntuacion(int puntuacion) {
		return this.puntuacion;
	}

}
