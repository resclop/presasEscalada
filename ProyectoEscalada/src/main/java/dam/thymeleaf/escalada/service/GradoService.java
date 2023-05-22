package dam.thymeleaf.escalada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.repositories.GradoRepository;
/**
 * Clase con finalidad service, es la que aporta un servicio a través de sus métodos 
 * @author Raul
 * @version 1.0
 */
@Service
public class GradoService {

	@Autowired
	private GradoRepository repositorio;
	
	public List<Grado> findAll(){
		return repositorio.findAll();
	}
	
	public List<Grado> findDestacadas(){
		return repositorio.findDestacadas();
	}
	
	public Grado save(Grado grado) {
		return repositorio.save(grado);
	}
	
	public Grado findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Grado delete(Grado grado) {
		Grado result = findById(grado.getId());
		repositorio.delete(result);
		return result;
	}
}
