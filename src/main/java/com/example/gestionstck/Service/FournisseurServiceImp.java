package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.Fournisseur;
import com.example.gestionstck.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImp implements FournisseurService{
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id).get();
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.saveAndFlush(fournisseur);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
