package com.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.modelo.Agencia;
import com.web.modelo.Cliente;
import com.web.repositorios.IAgencia;
import com.web.repositorios.ICliente;
@Service("agencia")
public class AgenciaService {
	@Autowired
	private IAgencia iAgencia;
	public void guardar(Agencia agencia) {
		iAgencia.save(agencia);
	}	
	public List<Agencia> listar (){
		 return iAgencia.findAll();
	}	
	public  Agencia buscar(Long agenciaId) {
		return  iAgencia.findByAgenciaId(agenciaId);
	}	
	public boolean eliminar (Long agenciaId) {
		try {
			iAgencia.delete(iAgencia.findByAgenciaId(agenciaId));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
