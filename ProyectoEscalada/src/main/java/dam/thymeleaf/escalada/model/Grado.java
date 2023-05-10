package dam.thymeleaf.escalada.model;

import java.util.List;

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
	private boolean destacada;
	
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