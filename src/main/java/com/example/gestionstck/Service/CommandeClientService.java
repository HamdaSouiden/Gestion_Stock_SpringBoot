package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.CommandeClient;
import com.example.gestionstck.Entity.Produits;

import java.util.List;

public interface CommandeClientService {
    List<CommandeClient> getAllCommandeClient();
    CommandeClient createCommandeClient(CommandeClient commandeClient);
    CommandeClient getCommandeClientById(Long id);
    CommandeClient updateCommandeClient(CommandeClient commandeClient);
    void deleteCommandeClient(Long id);
}
