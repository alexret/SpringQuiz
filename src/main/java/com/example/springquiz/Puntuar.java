package com.example.springquiz;

public class Puntuar {
	
	private String nombrejugador;
	private int puntuacionjugador;
	
	public Puntuar() {
		
	}
	
	public Puntuar(String nombrejugador, int puntuacionjugador) {
		setNombrejugador(nombrejugador);
		setPuntuacionjugador(puntuacionjugador);
	}
	
	public String getNombrejugador() {
		return nombrejugador;
	}
	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}
	public int getPuntuacionjugador() {
		return puntuacionjugador;
	}
	public void setPuntuacionjugador(int puntuacionjugador) {
		this.puntuacionjugador = puntuacionjugador;
	}
	
	

}
