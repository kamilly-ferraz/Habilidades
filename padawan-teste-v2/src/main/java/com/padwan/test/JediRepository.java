package com.padwan.test.repository;

import com.padwan.test.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    // Consulta 1: Listar mestres Jedis e seus aprendizes
    @Query(value = "SELECT j1.nome AS mestre, j2.nome AS padawan " +
                   "FROM jedis j1 LEFT JOIN jedis j2 ON j1.nome = j2.mentor " +
                   "WHERE j1.status = 'Mestre Jedi'", nativeQuery = true)
    List<Map<String, String>> findMastersWithApprentices();

    // Consulta 2: Listar Jedis com midichlorians acima de 9000
    @Query(value = "SELECT nome, status, midichlorians FROM jedis WHERE midichlorians > 9000", nativeQuery = true)
    List<Jedi> findJedisWithHighMidichlorians();

    // Consulta 3: Contagem de Jedis por categoria
    @Query(value = "SELECT status, COUNT(*) AS quantidade FROM jedis GROUP BY status", nativeQuery = true)
    List<Map<String, Object>> findJedisCountByCategory();
}
