package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.LigneCommandeFournisseur;
import com.example.gestionstck.Repository.LigneCommandeFournisseurRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeFImp implements LigneCommandeFournisseurService{
    @Autowired
    private LigneCommandeFournisseurRepos ligneCommandeFournisseurRepos;
    @Override
    public List<LigneCommandeFournisseur> getAllLigneCommandeFournisseur() {
        return ligneCommandeFournisseurRepos.findAll();
    }

    @Override
    public LigneCommandeFournisseur createLigneCommandeFournisseur(LigneCommandeFournisseur ligneCommandeFournisseur) {
        return ligneCommandeFournisseurRepos.save(ligneCommandeFournisseur);
    }

    @Override
    public LigneCommandeFournisseur getLigneCommandeFournisseurById(Long id) {
        return ligneCommandeFournisseurRepos.findById(id).get();
    }

    @Override
    public LigneCommandeFournisseur updateLigneCommandeFournisseur(LigneCommandeFournisseur ligneCommandeFournisseur) {
        return ligneCommandeFournisseurRepos.saveAndFlush(ligneCommandeFournisseur);
    }

    @Override
    public void deleteLigneCommandeFournisseur(Long id) {
        ligneCommandeFournisseurRepos.deleteById(id);
    }
}
