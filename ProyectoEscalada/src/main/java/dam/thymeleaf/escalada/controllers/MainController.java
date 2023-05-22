package dam.thymeleaf.escalada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.repositories.HoldRepository;
import dam.thymeleaf.escalada.service.CalidadService;
import dam.thymeleaf.escalada.service.GradoService;
import dam.thymeleaf.escalada.service.HoldService;
/**
 * Clase controller principal, recibe peticiones http y trata de responderlas, está autocableada con los distintos
 * servicios donde se iniciaran dichas peticiones, y cuenta con diferentes métodos que actuaran como la "URL"
 * @author Raul
 * @version 1.0
 */
@Controller
public class MainController {
	
	// @Autowired permite la inyección de dependencias, crea instancias de la clase que otro objeto necesita para poder utilizarlo
	@Autowired
	private GradoService gradoService;

	@Autowired
	private HoldService holdService;

	@Autowired
	private CalidadService calidadService;

	/**
	 * Método encargado de mapear el inicio de la web con "/", mostrará 8 producos de manera aleatoria y 
	 * los tipos de grados que hay, haciendo uso del index
	 * @param idGrado
	 * @param model
	 * @return
	 */
	//GetMapping permite simplificar el manejo de métodos MVC
	@GetMapping("/")
	public String index(@RequestParam(name="idGrado", required=false)Long idGrado, Model model) {
		List<Presa> presas;

		if(idGrado==null) {
			presas = holdService.obtenerPresasAleatorias(HoldRepository.PRODUCTOS_ALEATORIOS);
		} else {
			presas = holdService.findAllByGrado(idGrado);
		}
		model.addAttribute("grados", gradoService.findAll());
		model.addAttribute("presas", presas);
		return "index";
	}

	@GetMapping("/buscar")
	public String buscar(Model model,@RequestParam @Param("palabraClave") String palabraClave) {

		List<Presa> listaPresas = holdService.listAll(palabraClave);
		model.addAttribute("presas", listaPresas);
		model.addAttribute("grados", gradoService.findAll());
		model.addAttribute("palabraClave", palabraClave);
		model.addAttribute("resultados", listaPresas.size());
		return "index";
	}

	@GetMapping("/presa/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Presa presa= holdService.findById(id);
		model.addAttribute("grados", gradoService.findAll());
		model.addAttribute("composicion", calidadService.findComposicion(id));
		if(presa!=null) {
			model.addAttribute(presa);
			return "detail";
		}
		return "redirect:/";
	}
}
