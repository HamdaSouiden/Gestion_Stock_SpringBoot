package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.LigneCommandeClient;
import com.example.gestionstck.Repository.LigneCommandeClientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeCImp implements LigneCommandeClientService {
    @Autowired
    private LigneCommandeClientRepos ligneCommandeClientRepos;
    @Override
    public List<LigneCommandeClient> getAllLigneCommandeClient() {
        return ligneCommandeClientRepos.findAll();
    }

    @Override
    public LigneCommandeClient createLigneCommandeClient(LigneCommandeClient ligneCommandeClient) {
        return ligneCommandeClientRepos.save(ligneCommandeClient);
    }

    @Override
    public LigneCommandeClient getLigneCommandeClientById(Long id) {
        return ligneCommandeClientRepos.findById(id).get();
    }

    @Override
    public LigneCommandeClient updateLigneCommandeClient(LigneCommandeClient ligneCommandeClient) {
        return ligneCommandeClientRepos.saveAndFlush(ligneCommandeClient);
    }

    @Override
    public void deleteLigneCommandeClient(Long id) {
        ligneCommandeClientRepos.deleteById(id);
    }
}
