package com.web.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.modelo.Producto;
@Repository
public interface IProducto extends JpaRepository<Producto, Serializable>{
	public abstract Producto findByCodigo(Long codigo);
	public abstract Producto findByNombre(String producto);
}
