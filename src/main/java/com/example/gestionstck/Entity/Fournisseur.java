package com.example.gestionstck.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="telephone")
    private Integer telephone;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.REMOVE)
    private List<CommandeFournisseur> commandeFournisseurs = new ArrayList<CommandeFournisseur>();
}
