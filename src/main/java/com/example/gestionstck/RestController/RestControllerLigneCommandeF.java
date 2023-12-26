package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.LigneCommandeFournisseur;
import com.example.gestionstck.Service.LigneCommandeFImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lignecommandefournisseur")
public class RestControllerLigneCommandeF {

    @Autowired
    private LigneCommandeFImp ligneCommandeFImp;

    @GetMapping("/all")
    public List<LigneCommandeFournisseur> getallLigneCommandeFournisseur(){
        return ligneCommandeFImp.getAllLigneCommandeFournisseur();
    }

    @PostMapping("/save")
    public LigneCommandeFournisseur addLigneCommandeFournisseur(@RequestBody LigneCommandeFournisseur ligneCommandeFournisseur){
        return ligneCommandeFImp.createLigneCommandeFournisseur(ligneCommandeFournisseur);
    }

    @GetMapping("/getone/{id}")
    public LigneCommandeFournisseur getoneLigneCommandeFournisseur(@PathVariable Long id){
        return ligneCommandeFImp.getLigneCommandeFournisseurById(id);
    }

    @PutMapping("/update/{id}")
    public LigneCommandeFournisseur updateLigneCommandeFournisseur(@PathVariable Long id, @RequestBody LigneCommandeFournisseur ligneCommandeFournisseur){
        LigneCommandeFournisseur ligneCommandeFournisseur1 = ligneCommandeFImp.getLigneCommandeFournisseurById(id);

        if (ligneCommandeFournisseur1 != null){
            ligneCommandeFournisseur.setId(id);
            return ligneCommandeFImp.updateLigneCommandeFournisseur(ligneCommandeFournisseur);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteLigneCommandeFournisseur(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (ligneCommandeFImp.getLigneCommandeFournisseurById(id) == null){
            message.put("etat", "ligne commande fournisseur not found");
            return message;
        }

        try {
            ligneCommandeFImp.deleteLigneCommandeFournisseur(id);
            message.put("etat", "ligne commande fournisseur deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "ligne commande fournisseur not deleted");
            return message;
        }
    }
}

