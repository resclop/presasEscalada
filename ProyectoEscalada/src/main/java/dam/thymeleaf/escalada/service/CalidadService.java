package dam.thymeleaf.escalada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dam.thymeleaf.escalada.model.Calidad;
import dam.thymeleaf.escalada.repositories.CalidadRepository;
/**
 * Clase service para obtener la composicion relacionada con las presas
 * @author Raul
 * @version 1.0
 */
@Service
public class CalidadService {

	 @Autowired
	 private CalidadRepository calidadRepository;
	 
	 /**
	  * Este método a través del id muestra su composición
	  * @param id indica el id de la presa
	  * @return devuelve el id de la presa
	  */
	 public Calidad findComposicion(Long id){
		 return calidadRepository.findComposicion(id);
	 }
}
