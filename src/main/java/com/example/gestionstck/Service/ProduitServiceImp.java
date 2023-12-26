package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.Produits;
import com.example.gestionstck.Repository.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImp implements ProduitService{

    @Autowired
    private ProduitsRepository produitsRepository;
    @Override
    public List<Produits> getAllProduit() {
        return produitsRepository.findAll();
    }

    @Override
    public Produits createProduit(Produits produits) {
        return produitsRepository.save(produits);
    }

    @Override
    public Produits getProduitById(Long id) {
        return produitsRepository.findById(id).get();
    }

    @Override
    public Produits updateProduit(Produits produits) {
        return produitsRepository.saveAndFlush(produits);
    }

    @Override
    public void deleteProduit(Long id) {
        produitsRepository.deleteById(id);
    }
}
