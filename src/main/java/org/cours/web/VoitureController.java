package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/voitures") // Définit le chemin de base de l'API
public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo; // Injecte le repository VoitureRepo

    @GetMapping // Gère les requêtes HTTP GET
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll(); // Récupère toutes les voitures depuis la base de données
    }
}
