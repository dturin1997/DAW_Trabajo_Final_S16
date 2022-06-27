package com.web.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.modelo.ClienteTour;
@Repository
public interface IClienteTour extends JpaRepository<ClienteTour, Serializable> {
	public abstract ClienteTour findById(Long codigo);
}
