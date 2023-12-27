package com.cordeiro.springProject;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.repositorys.CategoriaRepository;


@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	@Autowired 
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	public void run (String...args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "enfermagem");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}
	
}
