package com.web.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.modelo.Venta;
@Repository
public interface IVenta extends JpaRepository<Venta, Serializable>{
	public abstract Venta findByCodigo(Long codigo);
}
