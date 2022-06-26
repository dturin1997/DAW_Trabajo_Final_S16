package com.web.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="CLIENTES_TOURS")
public class ClienteTour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotNull
	private Long cliente_codigo;
	@NotNull
	private Long tour_codigo;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		return "ClienteTour [codigo=" + codigo + ", cliente_codigo=" + cliente_codigo + ", tour_codigo=" + tour_codigo
				+ "]";
	}
	
}
