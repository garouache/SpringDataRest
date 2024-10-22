package org.cours;

import static org.assertj.core.api.Assertions.assertThat;

import org.cours.web.VoitureController; // Remplacez par le chemin d'accès correct à votre contrôleur
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Indique que c'est une classe de test qui exécute les tests à base de Spring Boot
class SpringDataRestApplicationTests {

    @Autowired
    private VoitureController voitureController; // Injecte le contrôleur à tester

    @Test // Indique que cette méthode peut être exécutée comme un cas de test
    void contextLoads() {
        // Vérifie si l'instance du contrôleur a été créée et injectée avec succès
        assertThat(voitureController).isNotNull();
    }
}
