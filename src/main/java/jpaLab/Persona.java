package jpaLab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona {

	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", orphanRemoval = true)
	private List<Address> direcciones = new ArrayList<Address>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Address> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Address> direcciones) {
		this.direcciones = direcciones;
	}

}
