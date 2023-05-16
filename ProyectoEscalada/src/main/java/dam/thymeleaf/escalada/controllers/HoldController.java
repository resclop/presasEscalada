package dam.thymeleaf.escalada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	/**
	 * Método para el buscador
	 * @param model
	 * @param palabraClave
	 * @return
	 */
	@GetMapping("/buscar")
	public String buscar(Model model, @Param("palabraClave") String palabraClave) {
		List<Presa> listaPresas = holdService.listAll(palabraClave);
		model.addAttribute("presas", listaPresas);
		model.addAttribute("grados", gradoService.findAll());
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String nuevoPresa(Model model) {
		model.addAttribute("presa", new Presa());
		model.addAttribute("grados", this.gradoService.findAll());
		return "admin/form-presa";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoPresa(Presa presa, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("grados", gradoService.findAll());
			return "admin/form-presa";
		} else {
			holdService.save(presa);
			return "redirect:/admin/presas/";
		}
	}

	@GetMapping("/editar/{id}")
	public String editarPresa(@PathVariable("id") Long id, Model model) {
		Presa presa = holdService.findById(id);

		if (presa != null) {
			model.addAttribute("presa", presa);
			model.addAttribute("grados", holdService.findAll());
			return "admin/form-presa";
		} else {
			return "redirect:/admin/presa/";
		}
	}

	@GetMapping("/borrar/{id}")
	public String borrarPresa(@PathVariable("id") Long id, Model model) {
		Presa presa =holdService.findById(id);
		if (presa != null) {
			holdService.delete(presa);
		}
		return "redirect:/admin/presa/";
	}
}
