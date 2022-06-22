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

import com.web.modelo.Agencia;
import com.web.modelo.Cliente;
import com.web.servicios.AgenciaService;
import com.web.servicios.ClienteService;

@Controller
@RequestMapping("/agencias")
@SessionAttributes("agencia")
public class AgenciaController {
	@Autowired
	@Qualifier("agencia")
	AgenciaService agenciaService;	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Agencia> agencias =agenciaService.listar();
		model.addAttribute("agencias",agencias);
		model.addAttribute("titulo","Lista de Agencias");
		return "agenciaListar";
	}	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Agencia agencia = new Agencia();
		model.put("agencia",agencia);
		model.put("btn", "Crear Agencia");
		return "agenciaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("agencia",agenciaService.buscar(id));
		model.addAttribute("btn","Actualiza Agencia");
		return "agenciaForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Agencia agencia,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			agencia = new Agencia();
			model.addAttribute("agencia",agencia);
			model.addAttribute("btn", "Crear Agencia");
			return "agenciaForm";
		}else {
		agenciaService.guardar(agencia);
		return "redirect:/agencias/listar";
		}
	}	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		agenciaService.eliminar(id);
		return"redirect:/agencias/listar";
	}
}
