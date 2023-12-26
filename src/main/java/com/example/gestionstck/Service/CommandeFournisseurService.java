package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.CommandeFournisseur;

import java.util.List;

public interface CommandeFournisseurService {
    List<CommandeFournisseur> getAllCommandeFournisseur();
    CommandeFournisseur createCommandeFournisseur(CommandeFournisseur commandeFournisseur);
    CommandeFournisseur getCommandeFournisseurById(Long id);
    CommandeFournisseur updateCommandeFournisseur(CommandeFournisseur commandeFournisseur);
    void deleteCommandeFournisseur(Long id);
}
