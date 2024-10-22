package org.cours;

import static org.assertj.core.api.Assertions.assertThat;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY) // Utilise H2 pour les tests
public class VoitureRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoitureRepo voitureRepo;

    @Test
    public void ajouterVoiture() {
        // Crée une nouvelle voiture
        Voiture voiture = new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 180000);

        // Persiste la voiture dans la base de données H2
        entityManager.persistAndFlush(voiture);

        // Vérifie que l'ID de la voiture est non nul, ce qui signifie qu'elle a été ajoutée avec succès
        assertThat(voiture.getId()).isNotNull();
    }

    @Test
    public void supprimerVoiture() {
        // Ajoute deux voitures dans la base de données H2
        entityManager.persistAndFlush(new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000));
        entityManager.persistAndFlush(new Voiture("MiniCooper", "Uber", "Rouge", "C-2020", 2021, 180000));

        // Supprime toutes les voitures
        voitureRepo.deleteAll();

        // Vérifie que le repository est vide
        assertThat(voitureRepo.findAll()).isEmpty();
    }
}
