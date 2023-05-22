package dam.thymeleaf.escalada.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Clase que contiene la anotacion @Entity, indica que define el componente y especifica que es una clase
 * entidad, indica asociacion a una tabla en una bbdd, contiene constructores y los métodos 
 * get & set, junto a la relación con otra tabla
 * @author Raul
 * @version 1.0
 */
@Entity
public class Calidad {

	// Indica que la primera propiedad es el campo id de la tabla grado y 
	// @GeneratedValue se usa para generar los valores de una clave primaria  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String composicion;
	
	// @OneToMany indica la relación de que de una calidad, hay muchas presas
	@OneToMany
	private List<Presa> presa;
	
	public Calidad() {}
	
	public Calidad(String composicion) {
		this.composicion = composicion;
	}

	public String getComposicion() {
		return composicion;
	}

	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
