package com.daniel.crudspringbootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.crudspringbootthymeleaf.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    
}
