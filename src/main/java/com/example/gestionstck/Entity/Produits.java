package com.example.gestionstck.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private String prix;

    @Column(name = "stock")
    private String stock;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<LigneCommandeClient> ligneCommandeClients = new ArrayList<LigneCommandeClient>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs = new ArrayList<LigneCommandeFournisseur>();

}
