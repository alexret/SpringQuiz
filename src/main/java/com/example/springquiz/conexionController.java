package com.example.springquiz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class conexionController implements preguntaDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(String usuario, int puntuacion) {
		return jdbcTemplate.update("insert into usuarios (Nombre, Puntuacion) values(?,?)",usuario, puntuacion);
	}
	
}
