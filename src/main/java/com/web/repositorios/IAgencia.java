package com.web.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.modelo.Agencia;
import com.web.modelo.Cliente;
@Repository
public interface IAgencia extends JpaRepository<Agencia, Serializable>{
	public abstract Agencia findByAgenciaId(Long agenciaId);
}
