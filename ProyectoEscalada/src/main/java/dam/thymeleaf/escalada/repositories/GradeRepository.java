package dam.thymeleaf.escalada.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.escalada.model.Grado;

public interface GradeRepository extends JpaRepository<Grado, Long>{

	@Query("select * from Grado where destacada = true")
	public List<Grado> findDestacadas();
}
