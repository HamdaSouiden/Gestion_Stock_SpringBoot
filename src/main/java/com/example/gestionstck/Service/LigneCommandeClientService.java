package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.LigneCommandeClient;

import java.util.List;

public interface LigneCommandeClientService {
    List<LigneCommandeClient> getAllLigneCommandeClient();
    LigneCommandeClient createLigneCommandeClient(LigneCommandeClient ligneCommandeClient);
    LigneCommandeClient getLigneCommandeClientById(Long id);
    LigneCommandeClient updateLigneCommandeClient(LigneCommandeClient ligneCommandeClient);
    void deleteLigneCommandeClient(Long id);
}
