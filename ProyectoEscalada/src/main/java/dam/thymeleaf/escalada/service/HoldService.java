package dam.thymeleaf.escalada.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.repositories.HoldRepository;

@Service
public class HoldService {

	@Autowired
	private HoldRepository holdRepository;
	
	public List<Presa> findAll(){
		return holdRepository.findAll();
	}
	
	public List<Presa> findAllByGrade(Long grado){
		return holdRepository.findByGradeId(grado);
	}
	
	//No encuentra el findbygradeid
	public List<Presa> findAllByGrade(Grado grade){
		return holdRepository.findByGrade(grade);
	}
	
	public Presa findById(Long id){
		return holdRepository.findById(id).orElse(null);
	}
	
	public Presa save(Presa presa) {
		return holdRepository.save(presa);
	}
	
	public Presa delete(Presa presa) {
		Presa result = findById(presa.getId());
		holdRepository.delete(result);
		return result;
	}
	
	public List<Presa> obtenerPresasAleatorias(int productosAleatorios){
		List<Long> listaIds = holdRepository.obtenerIds();
		Collections.shuffle(listaIds);
		listaIds = listaIds.stream().limit(productosAleatorios).collect(Collectors.toList());
		return holdRepository.findAllById(listaIds);
		
	}
}
