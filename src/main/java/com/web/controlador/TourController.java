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
import com.web.modelo.Tour;
import com.web.servicios.AgenciaService;
import com.web.servicios.TourService;

@Controller
@RequestMapping("/tours")
@SessionAttributes("tour")
public class TourController {
	
		@Autowired
		@Qualifier("tour")
		TourService tourService;	
		@RequestMapping("/listar")
		public String listar (Model model ) {
			List<Tour> tours = tourService.listar();
			model.addAttribute("tours",tours);
			model.addAttribute("titulo","Lista de Tours");
			return "tourListar";
		}	
		@RequestMapping("/form")
		public String formulario (Map<String, Object> model) {
			Tour tour = new Tour();
			model.put("tour",tour);
			model.put("btn", "Crear Tour");
			return "tourForm";
		}
		
		@RequestMapping("/form/{id}")
		public String actualizar (@PathVariable("id") Long id,Model model) {
			model.addAttribute("tour",tourService.buscar(id));
			model.addAttribute("btn","Actualiza Tour");
			return "tourForm";
		}
		@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
		public String guardar(@Validated Tour tour,BindingResult result,Model model) {		
			if(result.hasErrors()) {
				model.addAttribute("ERROR","Error al enviar registro");
				tour = new Tour();
				model.addAttribute("tour",tour);
				model.addAttribute("btn", "Crear Tour");
				return "tourForm";
			}else {
			tourService.guardar(tour);
			return "redirect:/tours/listar";
			}
		}	
		@RequestMapping("/eliminar/{id}")
		public String eliminar(@PathVariable("id") Long id) {
			tourService.eliminar(id);
			return"redirect:/tours/listar";
		}
}
