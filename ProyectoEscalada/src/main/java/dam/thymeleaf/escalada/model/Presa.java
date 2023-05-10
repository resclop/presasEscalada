package dam.thymeleaf.escalada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Presa {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private float precio;
	private String imagen;
	
	@ManyToOne
	private Grado grado;
	
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