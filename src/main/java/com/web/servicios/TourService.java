package com.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.modelo.Cliente;
import com.web.modelo.Tour;
import com.web.repositorios.ICliente;
import com.web.repositorios.ITour;

@Service("tour")
public class TourService {
	@Autowired
	private ITour iTour;
	public void guardar(Tour tour) {
		iTour.save(tour);
	}	
	public List<Tour> listar (){
		
		 return iTour.findAll();
	}	
	public  Tour buscar(Long codigo) {
		return  iTour.findByCodigo(codigo);
	}	
	public boolean eliminar (Long codigo) {
		try {
			iTour.delete(iTour.findByCodigo(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
