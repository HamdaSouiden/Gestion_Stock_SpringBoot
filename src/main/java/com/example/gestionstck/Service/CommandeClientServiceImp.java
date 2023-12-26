package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.CommandeClient;
import com.example.gestionstck.Repository.CommandeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeClientServiceImp implements CommandeClientService{
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Override
    public List<CommandeClient> getAllCommandeClient() {
        return commandeClientRepository.findAll();
    }

    @Override
    public CommandeClient createCommandeClient(CommandeClient commandeClient) {
        return commandeClientRepository.save(commandeClient);
    }

    @Override
    public CommandeClient getCommandeClientById(Long id) {
        return commandeClientRepository.findById(id).get();
    }

    @Override
    public CommandeClient updateCommandeClient(CommandeClient commandeClient) {
        return commandeClientRepository.saveAndFlush(commandeClient);
    }

    @Override
    public void deleteCommandeClient(Long id) {
        commandeClientRepository.deleteById(id);
    }
}
