package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.CommandeFournisseur;
import com.example.gestionstck.Repository.CommandeFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeFournisseurServiceImp implements CommandeFournisseurService{

    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;
    @Override
    public List<CommandeFournisseur> getAllCommandeFournisseur() {
        return commandeFournisseurRepository.findAll();
    }

    @Override
    public CommandeFournisseur createCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        return commandeFournisseurRepository.save(commandeFournisseur);
    }

    @Override
    public CommandeFournisseur getCommandeFournisseurById(Long id) {
        return commandeFournisseurRepository.findById(id).get();
    }

    @Override
    public CommandeFournisseur updateCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        return commandeFournisseurRepository.saveAndFlush(commandeFournisseur);
    }

    @Override
    public void deleteCommandeFournisseur(Long id) {
        commandeFournisseurRepository.deleteById(id);
    }
}
