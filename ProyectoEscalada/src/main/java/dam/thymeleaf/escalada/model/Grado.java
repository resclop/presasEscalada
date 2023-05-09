package dam.thymeleaf.escalada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "grado")
public class Grado {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	@OneToMany
	private Presa presa;
	
	
	public Grado() {}
	
	public Grado(String nombre) {
		this.nombre = nombre;
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
	
	
}