package com.padwan.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kamillyferraz")
public class KamillySkillsController {

    /**
     * Endpoint que retorna as principais habilidades de Kamilly Ferraz.
     *
     * @return Um mapa com o nome como chave e as habilidades como valor.
     */
    @GetMapping("/skills")
    public Map<String, Object> listSkills() {
        // Criação do mapa de resposta
        Map<String, Object> response = new HashMap<>();
        
        // Adicionando nome como chave e habilidades como valor
        response.put("Kamilly Ferraz", new String[]{
                "Desenvolvimento de Software",
                "Esforço Constante para Aprender e Melhorar",
                "Boa Comunicação",
                "Proatividade",
                "Organização Exemplar",
                "Projetos Ágeis",
                "Liderança natural"
        });
        
        return response; // Retorno da resposta
    }
}
