package dam.thymeleaf.escalada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.service.GradoService;
import dam.thymeleaf.escalada.service.HoldService;

@Controller
@RequestMapping("/admin/presa")
public class HoldController {

	@Autowired
	private HoldService holdService;
	
	@Autowired
	private GradoService gradoService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("presas", holdService.findAll());
		return "admin/list-presa";
	}
	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		model.addAttribute("presa", new Presa());
		model.addAttribute("grados", this.gradoService.findAll());
		return "admin/form-presa";
	}
	
	
}
