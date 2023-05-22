package dam.thymeleaf.escalada.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase que contiene la anotacion @Entity, indica que define el componente y especifica que es una clase
 * entidad, indica asociacion a una tabla en una bbdd, contiene constructores y los métodos 
 * get & set, junto a la relación con otra tabla
 * @author Raul
 * @version 1.0
 */
@Entity
@Table(name= "grado")
public class Grado {
	
	// Indica que la primera propiedad es el campo id de la tabla grado y 
	// @GeneratedValue se usa para generar los valores de una clave primaria  
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private boolean destacada;
	
	// @OneToMany indica la relación de que en un grado, hay muchas presas
	@OneToMany
	private List<Presa> presa;
	
	
	public Grado() {}
	
	public Grado(String nombre, boolean destacada) {
		this.nombre = nombre;
		this.destacada = destacada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDestacada() {
		return destacada;
	}

	public void setDestacada(boolean destacada) {
		this.destacada = destacada;
	}
	
	
}