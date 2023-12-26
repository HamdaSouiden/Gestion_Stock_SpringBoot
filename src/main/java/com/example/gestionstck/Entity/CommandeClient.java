package com.example.gestionstck.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_commande")
    private Date dateCommande;

    @OneToMany(mappedBy = "commandeClient", cascade = CascadeType.REMOVE)
    private List<LigneCommandeClient> ligneCommandeClient = new ArrayList<LigneCommandeClient>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

