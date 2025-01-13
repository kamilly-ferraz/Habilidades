package com.padwan.test.controller;

import com.padwan.test.model.Jedi;
import com.padwan.test.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jedis")
public class JediController {

    @Autowired
    private JediRepository jediRepository;

    // Endpoint para listar todos os Jedis
    @GetMapping("/all")
    public List<Jedi> getJedis() {
        return jediRepository.findAll();
    }

    // Endpoint para listar mestres Jedis e seus aprendizes
    @GetMapping("/masters-with-apprentices")
    public List<Map<String, String>> getMastersWithApprentices() {
        return jediRepository.findMastersWithApprentices();
    }

    // Endpoint para listar Jedis com midichlorians acima de 9000
    @GetMapping("/above-9000")
    public List<Jedi> getJedisWithHighMidichlorians() {
        return jediRepository.findJedisWithHighMidichlorians();
    }

    // Endpoint para contar Jedis por categoria
    @GetMapping("/count-by-category")
    public List<Map<String, Object>> getJedisCountByCategory() {
        return jediRepository.findJedisCountByCategory();
    }
}
