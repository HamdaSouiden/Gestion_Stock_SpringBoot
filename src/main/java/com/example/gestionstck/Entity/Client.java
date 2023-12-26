package com.example.gestionstck.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client {
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<CommandeClient> commandeClients = new ArrayList<CommandeClient>();
}
