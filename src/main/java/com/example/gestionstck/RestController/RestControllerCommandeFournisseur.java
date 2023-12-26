package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.CommandeFournisseur;
import com.example.gestionstck.Service.CommandeFournisseurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commandefournisseur")
public class RestControllerCommandeFournisseur {

    @Autowired
    private CommandeFournisseurServiceImp commandeFournisseurServiceImp;

    @GetMapping("/all")
    public List<CommandeFournisseur> getallCommandeFournisseur(){
        return commandeFournisseurServiceImp.getAllCommandeFournisseur();
    }

    @PostMapping("/save")
    public CommandeFournisseur addCommandeFournisseur(@RequestBody CommandeFournisseur commandeFournisseur){
        return commandeFournisseurServiceImp.createCommandeFournisseur(commandeFournisseur);
    }

    @GetMapping("/getone/{id}")
    public CommandeFournisseur getoneCommandeFournisseur(@PathVariable Long id){
        return commandeFournisseurServiceImp.getCommandeFournisseurById(id);
    }

    @PutMapping("/update/{id}")
    public CommandeFournisseur updateCommandeFournisseur(@PathVariable Long id, @RequestBody CommandeFournisseur commandeFournisseur){
        CommandeFournisseur commandeFournisseur1 = commandeFournisseurServiceImp.getCommandeFournisseurById(id);

        if (commandeFournisseur1 != null){
            commandeFournisseur.setId(id);
            return commandeFournisseurServiceImp.updateCommandeFournisseur(commandeFournisseur);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteCommandeFournisseur(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (commandeFournisseurServiceImp.getCommandeFournisseurById(id) == null){
            message.put("etat", "Commande fournisseur not founs");
            return message;
        }
        try {
            commandeFournisseurServiceImp.deleteCommandeFournisseur(id);
            message.put("etat", "Commande Fournissuer deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "Commande Fournisseur not deleted");
            return message;
        }
    }
}
