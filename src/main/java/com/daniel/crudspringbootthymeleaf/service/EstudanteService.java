package com.daniel.crudspringbootthymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniel.crudspringbootthymeleaf.model.Estudante;
import com.daniel.crudspringbootthymeleaf.repository.EstudanteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    public Estudante criarEstudante(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> listarTodosEstudantes(){
        return estudanteRepository.findAll();
    }
}
