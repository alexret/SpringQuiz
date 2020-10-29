package com.example.springquiz;

import java.util.List;

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
	public List<Puntuacion> recogerdatos() {
	    String sql = "SELECT Nombre, Puntuacion FROM usuarios";

	    return jdbcTemplate.query(
	            sql,
	            (rs, puntuacion) ->
	                    new Puntuacion(
	                            rs.getString("Nombre"),
	                            rs.getInt("Puntuacion")
	                    )
	    );
	}

	@Override
	public int save(String usuario, int puntuacion) {
		return jdbcTemplate.update("insert into usuarios (Nombre, Puntuacion) values(?,?)",usuario, puntuacion);
	}
	
}
