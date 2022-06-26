package com.web.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.modelo.ClienteTour;
import com.web.servicios.ClienteTourService;

@Controller
@RequestMapping("/clientetours")
@SessionAttributes("clientetour")
public class ClienteTourController {
	@Autowired
	@Qualifier("clientetour")
	ClienteTourService clientetourService;	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<ClienteTour> clientetours = clientetourService.listar();
		model.addAttribute("clientetours",clientetours);
		model.addAttribute("titulo","Lista de Clientes - Tours");
		return "clientetourListar";
	}	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		ClienteTour clientetour = new ClienteTour();
		model.put("clientetour",clientetour);
		model.put("btn", "Crear Cliente - Tour");
		return "clientetourForm";
	}
	
	@RequestMapping("/form/{cod}")
	public String actualizar (@PathVariable("cod") Long cod,Model model) {
		model.addAttribute("clientetour",clientetourService.buscar(cod));
		model.addAttribute("btn","Actualiza Cliente - Tour");
		return "clientetourForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated ClienteTour clientetour,BindingResult resultado,Model model) {		
		if(resultado.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			clientetour = new ClienteTour();
			model.addAttribute("clientetour",clientetour);
			model.addAttribute("btn", "Crear Cliente - Tour");
			return "clientetourForm";
		}else {
		clientetourService.guardar(clientetour);
		return "redirect:/clientetours/listar";
		}
	}	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		clientetourService.eliminar(id);
		return"redirect:/clientetours/listar";
	}
}
