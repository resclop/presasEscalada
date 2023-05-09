package dam.thymeleaf.escalada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.service.GradeService;
import dam.thymeleaf.escalada.service.HoldService;

@Controller
@RequestMapping("/admin/presa")
public class GradeController {

	@Autowired
	private HoldService holdService;
	
	@Autowired
	private GradeService gradeService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("grados", gradeService.findAll());
		return "admin/list-grado";
	}
	
	@GetMapping("/nueva")
	public String nuevoGrado(Model model) {
		model.addAttribute("grado", new Grado());
		return "admin/form-grado";
	}
	
	
}
