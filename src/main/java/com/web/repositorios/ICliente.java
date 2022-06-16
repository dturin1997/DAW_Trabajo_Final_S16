package com.web.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.modelo.Cliente;
@Repository
public interface ICliente extends JpaRepository<Cliente, Serializable>{
	public abstract Cliente findByCodigo(Long codigo);
}
