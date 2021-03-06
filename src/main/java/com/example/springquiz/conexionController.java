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
	public List<Puntuar> recogerdatos() {
	    String sql = "SELECT nombre, puntuacion FROM usuarios order by puntuacion desc";

	    return jdbcTemplate.query(sql,(rs, puntuacion) ->new Puntuar(rs.getString("nombre"),rs.getInt("puntuacion")));
	}

	@Override
	public int save(String usuario, int puntuacion) {
		return jdbcTemplate.update("insert into usuarios (nombre, puntuacion) values(?,?)",usuario, puntuacion);
	}
	
}
