package com.web.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="CLIENTES_TOURS")
public class ClienteTour implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3061291845719924114L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private Long cliente_codigo;
	@NotNull
	private Long tour_codigo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente_codigo() {
		return cliente_codigo;
	}
	public void setCliente_codigo(Long cliente_codigo) {
		this.cliente_codigo = cliente_codigo;
	}
	public Long getTour_codigo() {
		return tour_codigo;
	}
	public void setTour_codigo(Long tour_codigo) {
		this.tour_codigo = tour_codigo;
	}
	@Override
	public String toString() {
		return "ClienteTour [id=" + id + ", cliente_codigo=" + cliente_codigo + ", tour_codigo=" + tour_codigo + "]";
	}
	
	
	
}
