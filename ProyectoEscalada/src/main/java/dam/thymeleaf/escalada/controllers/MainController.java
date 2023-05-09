package dam.thymeleaf.escalada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.repositories.HoldRepository;
import dam.thymeleaf.escalada.service.GradeService;
import dam.thymeleaf.escalada.service.HoldService;

public class MainController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private HoldService holdService;
	
	@GetMapping("/")
	public String index(@RequestParam(name="idGrado", required=false)Long idGrado, Model model) {
		List<Presa> presas;
		
		if(idGrado==null) {
			presas = holdService.obtenerPresasAleatorias(HoldRepository.PRODUCTOS_ALEATORIOS);
		} else {
			presas = holdService.findAllByGrade(idGrado);
		}
		
		model.addAttribute("grados", gradeService.findAll());
		model.addAttribute("presas", presas);
		
		return "index";
	}
}
