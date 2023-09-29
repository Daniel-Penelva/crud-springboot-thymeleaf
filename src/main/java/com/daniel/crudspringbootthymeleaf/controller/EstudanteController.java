package com.daniel.crudspringbootthymeleaf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniel.crudspringbootthymeleaf.exception.EstudanteNotFoundException;
import com.daniel.crudspringbootthymeleaf.model.Estudante;
import com.daniel.crudspringbootthymeleaf.service.EstudanteService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    // Acessar Aplicação - http://localhost:8080/
    
    @GetMapping("/")
    public String listarEstudantes(Model model) {
        
        List<Estudante> estudantes = estudanteService.listarTodosEstudantes();
        
        model.addAttribute("listarEstudantes", estudantes);
        
        return "/lista-estudantes";
    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {

        Estudante estudante = new Estudante();

        model.addAttribute("novoEstudante", estudante);

        return "/novo-estudante";
    }

    @PostMapping("/gravarEstudante")
    public String gravarEstudante(@ModelAttribute("novoEstudante") @Valid Estudante estudante,
            BindingResult erros, RedirectAttributes redirectAttributes) {
        
        if(erros.hasErrors()){
            return "/novo-estudante";
        }

        estudanteService.criarEstudante(estudante);

        redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");

        return "redirect:/novo";
    }


    @GetMapping("/apagar/{id}")
    public String apagarEstudante(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            estudanteService.deletarEstudante(id);
        } catch (EstudanteNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/";
    }


    // Esse método vai capturar o id do estudante e redirecionar para a tela '/alterar-estudante' já carregado com os seus dados na tela.
    @GetMapping("/editar/{id}")
    public String carregarEstudanteFormParaAlterar(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
        try {
            
            Estudante estudante = estudanteService.buscarEstudantePorId(id);

            model.addAttribute("editarEstudante", estudante);
            return "/alterar-estudante";
            
        } catch (EstudanteNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/";
    }


    @PostMapping("/editar/{id}")
    public String editarEstudante(@PathVariable("id") Long id, @ModelAttribute("editarEstudante") @Valid Estudante estudante,
            BindingResult erros) {
        
        if(erros.hasErrors()){
            estudante.setId(id);
            return "/alterar-estudante";
        }

        estudanteService.alterarEstudante(estudante);

        return "redirect:/";
    }

}
