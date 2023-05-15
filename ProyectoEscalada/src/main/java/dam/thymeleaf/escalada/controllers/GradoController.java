package dam.thymeleaf.escalada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.service.GradoService;
import dam.thymeleaf.escalada.service.HoldService;
/**
 * Clase controlador, llamada GradoController, contiene los métodos para almacenar las funciones.
 * @author Raul
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/grado")
public class GradoController {
	
	@Autowired
	private HoldService holdService;
	
	@Autowired
	private GradoService gradoService;
	
	/**
	 * Método encargado de devolver un listado de los grados,
	 * @param model 
	 * @return devuelve un listado con los grados de una base de datos
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("grados", gradoService.findAll());
		return "admin/list-grado";
	}
	
	@GetMapping("/nueva")
	public String nuevoGrado(Model model) {
		model.addAttribute("grado", new Grado());
		return "admin/form-grado";
	}
	

	@PostMapping("/nueva/submit")
	public String submitNuevaCategoria(@ModelAttribute("grado") Grado grado, Model model) {
		
		gradoService.save(grado);
		
		return "redirect:/admin/grado/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Grado grado= gradoService.findById(id);
		
		if (grado != null) {
			model.addAttribute("grado", grado);
			return "admin/form-grado";
		} else {
			return "redirect:/admin/grado/";
		}
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarGrado(@PathVariable("id") Long id, Model model) {
		Grado grado= gradoService.findById(id);
		if (grado != null) {
			
			if (holdService.numeroPresaGrado(grado) == 0) {
				gradoService.delete(grado);				
			} else {
				return "redirect:/admin/grado/?error=true";
			}
		} 
		return "redirect:/admin/grado/";
	}
	
}
