package com.cordeiro.springProject.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cordeiro.springProject.domain.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	Categoria cat1 = new Categoria (1,"Informatica");
	Categoria cat2 = new Categoria (1,"Enfermagem");
	
	@GetMapping("{id}")
	public List<Categoria> lista(){
		List<Categoria> lista = new ArrayList<Categoria>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;
		
	}

	

}
