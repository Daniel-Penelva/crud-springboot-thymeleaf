package com.daniel.crudspringbootthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daniel.crudspringbootthymeleaf.exception.EstudanteNotFoundException;
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


    public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException{
        Optional<Estudante> optional = estudanteRepository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new EstudanteNotFoundException("Estudante com id " + id + " não encontrado!");
        }
    }

    public void deletarEstudante(Long id) throws EstudanteNotFoundException{

        Estudante estudante = buscarEstudantePorId(id);
        estudanteRepository.delete(estudante);
    }
}
