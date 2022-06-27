package com.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.modelo.ClienteTour;
import com.web.repositorios.IClienteTour;

@Service("clientetour")
public class ClienteTourService {
	@Autowired
	private IClienteTour iClienteTour;
	public void guardar(ClienteTour clientetour) {
		iClienteTour.save(clientetour);
	}	
	public List<ClienteTour> listar (){
		
		 return iClienteTour.findAll();
	}	
	public  ClienteTour buscar(Long codigo) {
		return  iClienteTour.findById(codigo);
	}	
	public boolean eliminar (Long codigo) {
		try {
			iClienteTour.delete(iClienteTour.findById(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
