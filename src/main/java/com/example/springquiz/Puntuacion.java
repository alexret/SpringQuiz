package com.example.springquiz;

public class Puntuacion {
	
	public String nombrejugador;
	public int puntuacionjugador;
	
	public Puntuacion(String nombrejugador, int puntuacionjugador) {
		this.nombrejugador = nombrejugador;
		this.puntuacionjugador = puntuacionjugador;
	}
	
	
	public void setNombre(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}


	public void setPuntuacion(int puntuacionjugador) {
		this.puntuacionjugador = puntuacionjugador;
	}
	
	public String getNombre(String nombrejugador) {
		return nombrejugador;
	}


	public int getPuntuacion(int puntuacionjugador) {
		return puntuacionjugador;
	}

}
