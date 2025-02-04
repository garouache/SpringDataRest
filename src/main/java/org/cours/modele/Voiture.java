package org.cours.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NonNull
    private String marque;

    @NonNull
    private String modele;

    @NonNull
    private String couleur;

    @NonNull
    private String immatricule;

    @NonNull
    private int annee;

    @NonNull
    private int prix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire")
    @JsonIgnore
    @NonNull
    private Proprietaire proprietaire;

    public Voiture(String miolaCar, String uber, String blanche, String s, int i) {
    }

    public Voiture(String miolaCar, String uber, String blanche, String s, int i, int i1) {
    }
}
