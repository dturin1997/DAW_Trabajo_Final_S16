package com.web.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.modelo.Cliente;
import com.web.modelo.Tour;
@Repository
public interface ITour extends JpaRepository<Tour, Serializable> {
	public abstract Tour findByCodigo(Long codigo);
	/*@Query("SELECT t.codigo as codigo, "
			+ "t.destino as destino, "
			+ "t.precio as precio,"
			+ "a.nombre as nombre FROM tours t inner join agencias a on tours.agencias_id = agencias.agenciasId")
	List findAll();*/
}
