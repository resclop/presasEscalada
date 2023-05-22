package dam.thymeleaf.escalada.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.repositories.HoldRepository;

/**
 * Clase contenedora de servicios, en este caso, servicios relacionados con las presas, a través de determinados métodos 
 * se obtendrán los resultados
 * @author Raul
 * @version 1.0
 */
// @Service para reconocer la Clase HoldService como servicios que presta
@Service
public class HoldService {

	//Autocableado con HoldRepository (contiene las query)
	@Autowired
	private HoldRepository holdRepository;
	
	public List<Presa> findAll(){
		return holdRepository.findAll();
	}
	
	public List<Presa> findAllByGrado(Long grado){
		return holdRepository.findByGradoId(grado);
	}
	
	public List<Presa> findAllByGrado(Grado grado){
		return holdRepository.findByGrado(grado);
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
	public int numeroPresaGrado(Grado grado) {
		return holdRepository.findNumberHoldsByGrado(grado);
	}
	
	/**
	 * Método para obtener las presas de forma aleatoria
	 * @param productosAleatorios indica el numero de productos a aparecer
	 * @return devuelve una lista de ids de la bbdd
	 */
	public List<Presa> obtenerPresasAleatorias(int productosAleatorios){
		List<Long> listaIds = holdRepository.obtenerIds();
		Collections.shuffle(listaIds);
		listaIds = listaIds.stream().limit(productosAleatorios).collect(Collectors.toList());
		return holdRepository.findAllById(listaIds);
	}
	
	/**
	 * Este método hace de filtro para distinguir el TIPO de objeto que pasa se pasa por parámetro, si es tipo numérico
	 * o de tipo cadena
	 * @param palabraClave parámetro que del que se quieren obtener los datos de la bbdd
	 * @return devuelve un tipo de dato en función del filtrado, número o cadena
	 */
	public List<Presa> listAll(String palabraClave){
		float precio = -1;
		String nombrePresa="";
		try {
			precio = Float.parseFloat(palabraClave.toString());
		}catch(NumberFormatException e) {
			nombrePresa = palabraClave.toString();
		}
		if(precio>-1) {
			return holdRepository.findAll(precio);
		}else {
			return holdRepository.findAll(nombrePresa);
		}
	}
}
