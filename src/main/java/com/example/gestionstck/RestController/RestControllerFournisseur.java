package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.Fournisseur;
import com.example.gestionstck.Service.FournisseurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class RestControllerFournisseur {

    @Autowired
    private FournisseurServiceImp fournisseurServiceImp;

    @GetMapping("/all")
    public List<Fournisseur> getallFournisseur(){
        return fournisseurServiceImp.getAllFournisseur();
    }

    @PostMapping("/save")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurServiceImp.createFournisseur(fournisseur);
    }

    @GetMapping("/getone/{id}")
    public Fournisseur getOneFournisseur(@PathVariable Long id){
        return fournisseurServiceImp.getFournisseurById(id);
    }

    @PutMapping("/update/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur){
        Fournisseur fournisseur1 = fournisseurServiceImp.getFournisseurById(id);

        if (fournisseur1 != null){
            fournisseur.setId(id);
            return fournisseurServiceImp.updateFournisseur(fournisseur);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteFournisseur(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (fournisseurServiceImp.getFournisseurById(id) == null){
            message.put("etat", "fournisseur not found");
            return message;
        }
        try {
            fournisseurServiceImp.deleteFournisseur(id);
            message.put("etat", "fournisseur deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "founisseur not deleted");
            return message;
        }
    }
}
