package jpaLab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
	private String linea1;
	private String linea2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinea1() {
		return linea1;
	}

	public void setLinea1(String linea1) {
		this.linea1 = linea1;
	}

	public String getLinea2() {
		return linea2;
	}

	public void setLinea2(String linea2) {
		this.linea2 = linea2;
	}

}
