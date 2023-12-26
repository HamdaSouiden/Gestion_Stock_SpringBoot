package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.Produits;

import java.util.List;

public interface ProduitService {
    List<Produits> getAllProduit();
    Produits createProduit(Produits produits);
    Produits getProduitById(Long id);
    Produits updateProduit(Produits produits);
    void deleteProduit(Long id);
}
