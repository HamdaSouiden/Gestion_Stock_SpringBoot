package com.example.gestionstck.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class LigneCommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantite")
    private Integer quantite;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produits produit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commandeclient_id")
    private CommandeClient commandeClient;
}
