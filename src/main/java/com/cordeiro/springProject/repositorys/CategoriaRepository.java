package com.cordeiro.springProject.repositorys;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cordeiro.springProject.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Serializable> {

}
