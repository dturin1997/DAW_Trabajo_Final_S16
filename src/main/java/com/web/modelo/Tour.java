package com.web.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "TOURS")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotNull
	private String destino;
	@NotNull
	private double precio;
	@NotNull
	private Long agencia_id;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Long getAgencia_id() {
		return agencia_id;
	}
	public void setAgencia_id(Long agencia_id) {
		this.agencia_id = agencia_id;
	}
	@Override
	public String toString() {
		return "Tour [codigo=" + codigo + ", destino=" + destino + ", precio=" + precio + ", agencia_id=" + agencia_id
				+ "]";
	}

	

}
