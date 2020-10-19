package com.example.springquiz;

public class Pregunta {
	
	private String valor1;
	private String valor2;
	private String valor3;
	private String valor4;
	private String valor5;
	
	public Pregunta(String valor1, String valor2, String valor3, String valor4, String valor5) {
		setValor(valor1, valor2, valor3, valor4, valor5);
	}
	
	private void setValor(String valor1, String valor2, String valor3, String valor4, String valor5) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
		this.valor5 = valor5;
	}
	
	public String getValor1() {
		return valor1;
	}
	
	public String getValor2() {
		return valor2;
	}
	
	public String getValor3() {
		return valor3;
	}
	
	public String getValor4() {
		return valor4;
	}
	
	public String getValor5() {
		return valor5;
	}

}
