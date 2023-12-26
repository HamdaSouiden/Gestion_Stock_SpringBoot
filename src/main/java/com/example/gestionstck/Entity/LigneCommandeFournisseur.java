package com.example.gestionstck.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LigneCommandeFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantite")
    private Integer quantite;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produits product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commandefournisseur_id")
    private CommandeFournisseur commandeFournisseur;
}
