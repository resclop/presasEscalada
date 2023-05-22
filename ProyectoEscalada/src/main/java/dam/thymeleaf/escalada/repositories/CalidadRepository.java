package dam.thymeleaf.escalada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dam.thymeleaf.escalada.model.Calidad;

/**
 * Interfaz que implementa una query para buscar la composición de una presa por su id
 * @author Raul
 * @version 1.0
 */
public interface CalidadRepository extends JpaRepository<Calidad, Long>{

	// Se realiza un inner join de presa con calidad para buscar la composición de una presa por el mismo id
	@Query("select c.composicion from Presa p join Calidad c on p.calidad = c.id and p.id=?1")
	public Calidad findComposicion(Long id);

}
