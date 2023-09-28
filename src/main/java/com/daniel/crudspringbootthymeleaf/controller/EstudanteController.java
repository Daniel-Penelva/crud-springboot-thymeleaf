package com.daniel.crudspringbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.crudspringbootthymeleaf.service.EstudanteService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/")
    public String listarEstudantes(){
        return "/lista-estudantes"; 
    }
    
}

/**
 * OBS. ANOTAÇÃO @Controller
 * 
 * A anotação `@Controller` é uma anotação do Spring Framework usada para marcar uma classe como um controlador da camada de apresentação em um 
 * aplicativo da web. Os controladores desempenham um papel fundamental em estruturas de desenvolvimento da web baseadas em Spring, como o 
 * Spring MVC (Model-View-Controller).
 * 
 * características e funções associadas à anotação `@Controller`:
 * 
 * 1. Tratamento de Requisições HTTP: As classes anotadas com `@Controller` são responsáveis por tratar as requisições HTTP dos clientes da 
 *    aplicação da web. Eles definem métodos que são chamados quando um URL específico é acessado, e esses métodos lidam com a lógica de 
 *    processamento associada a essa solicitação.
 * 
 * 2. Mapeamento de URLs: A anotação `@Controller` frequentemente trabalha em conjunto com outras anotações, como `@RequestMapping`, para mapear 
 *    URLs específicos para métodos de controle. Por exemplo, você pode usar `@RequestMapping("/minharota")` antes de um método, indicando que 
 *    esse método deve ser executado quando a URL "/minharota" for acessada.
 * 
 * 3. Tratamento de Modelos e Visualizações: Os métodos de controle geralmente retornam um objeto `ModelAndView` que contém dados do modelo a 
 *    ser exibido na página e a visualização (template) que deve ser usada para renderizar a página. O Thymeleaf é comumente usado em conjunto 
 *    com controladores Spring para gerar páginas HTML.
 * 
 * 4. Gestão do Ciclo de Vida da Solicitação: Os controladores gerenciam o ciclo de vida da solicitação, lidando com a requisição, processando-a 
 *    e retornando uma resposta. Isso permite que implemente a lógica de negócios da aplicação e controle o fluxo das páginas da web.
 * 
 * 5. Integração com Outros Componentes: Os controladores geralmente se integram com outros componentes do Spring, como serviços, repositórios e 
 *    componentes de segurança, para buscar dados, aplicar lógica de negócios e muito mais.*/