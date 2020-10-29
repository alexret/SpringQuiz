package com.example.springquiz;

import java.util.List;

public interface preguntaDAO {
	
	int count();
	int save(String usuario, int puntuacion);
	List<Puntuacion> recogerdatos();

}
