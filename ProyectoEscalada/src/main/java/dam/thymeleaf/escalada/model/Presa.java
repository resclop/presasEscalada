package dam.thymeleaf.escalada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
/**
 * Clase que contiene la anotacion @Entity, indica que define el componente y especifica que es una clase
 * entidad, indica asociacion a una tabla en una bbdd
 * @author Raul
 * @version 1.0
 */
@Entity
public class Presa {

	// Indica que la primera propiedad es el campo id de la tabla presa y 
	// @GeneratedValue se usa para generar los valores de una clave primaria  
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private float precio;
	private String imagen;
	
	// La anotación indica la relación de que un grado lo tienen muchas presas
	@ManyToOne
	private Grado grado;
	
	// La anotación indica que una calidad la tiene una unica presa
	@ManyToOne
	private Calidad calidad;

	public Presa() {}
	
	public Presa(String nombre, float precio, String imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Grado getGrado() {
		return grado;
	}
	public void setGrado(Grado grado) {
		this.grado = grado;
	}
}