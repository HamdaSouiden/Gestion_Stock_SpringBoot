package com.example.gestionstck.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CommandeFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_commande")
    private Date dateCommande;

    @OneToMany(mappedBy = "commandeFournisseur", cascade = CascadeType.REMOVE)
    private List<LigneCommandeFournisseur> ligneCommandeFournisseur = new ArrayList<LigneCommandeFournisseur>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
}
