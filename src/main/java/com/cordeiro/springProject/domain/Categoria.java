package com.cordeiro.springProject.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Categoria implements Serializable   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	
	private Integer id ;
	private String name ;
	
	
	public Categoria () {
		
	}


	public Categoria(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	

}
