package com.example.springquiz;

public class Puntuacion {
	
	private String nombre;
	private int puntuacion;
	
	public Puntuacion(String nombre, int puntuacion) {
		setNombre(nombre);
		setPuntuacion(puntuacion);
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

}
