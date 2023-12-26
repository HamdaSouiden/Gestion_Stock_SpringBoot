package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.Fournisseur;

import java.util.List;

public interface FournisseurService {
    List<Fournisseur> getAllFournisseur();
    Fournisseur createFournisseur(Fournisseur fournisseur);
    Fournisseur getFournisseurById(Long id);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    void deleteFournisseur(Long id);
}
