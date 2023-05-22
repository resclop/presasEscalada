package dam.thymeleaf.escalada.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.model.Presa;

public interface HoldRepository extends JpaRepository<Presa, Long> {

	//Indica que el numero de productos aleatorios es igual a 8, es lo que muestra en la pantalla de inicio
	public final int PRODUCTOS_ALEATORIOS = 8;
	
	public List<Presa> findByGrado(Grado grado);
	
	@Query("select id from Presa")
	public List<Long> obtenerIds();
	
	// Hace una búsqueda de la presa según su id
	@Query("select p from Presa p where grado.id=?1")
	public List<Presa> findByGradoId(Long gradoid);
	
	@Query()
	public int findNumberHoldsByGrado(Grado grado);
	
	/**
	 * Método encargado de buscar la presa a traves de su nombre o precio
	 * @param palabraClave nombre que recibe el parametro de entrada ( 
	 * @return
	 */
	@Query("select p from Presa p where p.nombre like %?1%")
	public List<Presa> findAll(String nombrePresa);
	
	/**
	 * Método encargado de seleccionar el precio en función de si su valor es igual o MENOR
	 * cuando se realice una busqueda por precio, apareceran los datos cuando cumplan esa condicion
	 * @param precio precio indicado en el buscador
	 * @return devuelve un listado con los objetos que cumplan esa condicion
	 */
	@Query("select p from Presa p where p.precio<=?1")
	public List<Presa> findAll(float precio);
	
}
