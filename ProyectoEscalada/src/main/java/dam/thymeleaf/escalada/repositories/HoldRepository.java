package dam.thymeleaf.escalada.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.escalada.model.Grado;
import dam.thymeleaf.escalada.model.Presa;

public interface HoldRepository extends JpaRepository<Presa, Long> {

	public final int PRODUCTOS_ALEATORIOS = 8;
	public List<Presa> findByGrade(Grado grado);
	
	@Query("select presa.id from Presa")
	public List<Long> obtenerIds();
	
	@Query("select * from Presa where grado.id=?1")
	public List<Presa> findByGradeId(Long gradoid);
	
	@Query()
	public int findNumberHoldsByGrade(Grado grado);
}
