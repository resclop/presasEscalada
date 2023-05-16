package dam.thymeleaf.escalada.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.model.Presa;

public interface HoldRepository extends JpaRepository<Presa, Long> {

	public final int PRODUCTOS_ALEATORIOS = 8;
	public List<Presa> findByGrado(Grado grado);
	
	@Query("select id from Presa")
	public List<Long> obtenerIds();
	
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
	
	@Query("select p from Presa p where p.precio<=?1")
	public List<Presa> findAll(float precio);
	
}
