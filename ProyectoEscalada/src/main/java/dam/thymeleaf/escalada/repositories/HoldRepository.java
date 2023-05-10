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
}
