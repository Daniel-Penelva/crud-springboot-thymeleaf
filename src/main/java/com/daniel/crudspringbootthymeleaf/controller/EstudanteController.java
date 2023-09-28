package com.daniel.crudspringbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniel.crudspringbootthymeleaf.model.Estudante;
import com.daniel.crudspringbootthymeleaf.service.EstudanteService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/")
    public String listarEstudantes() {
        return "/lista-estudantes";
    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {

        Estudante estudante = new Estudante();

        model.addAttribute("novoEstudante", estudante);

        return "/novo-estudante";
    }

    @PostMapping("/gravarEstudante")
    public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante,
            RedirectAttributes redirectAttributes) {
        
        estudanteService.criarEstudante(estudante);

        redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");

        return "redirect:/novo";
    }
}
