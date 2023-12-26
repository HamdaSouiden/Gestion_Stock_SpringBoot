package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.LigneCommandeFournisseur;

import java.util.List;

public interface LigneCommandeFournisseurService {
    List<LigneCommandeFournisseur> getAllLigneCommandeFournisseur();
    LigneCommandeFournisseur createLigneCommandeFournisseur(LigneCommandeFournisseur ligneCommandeFournisseur);
    LigneCommandeFournisseur getLigneCommandeFournisseurById(Long id);
    LigneCommandeFournisseur updateLigneCommandeFournisseur(LigneCommandeFournisseur ligneCommandeFournisseur);
    void deleteLigneCommandeFournisseur(Long id);
}
