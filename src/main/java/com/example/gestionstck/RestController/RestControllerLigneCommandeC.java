package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.LigneCommandeClient;
import com.example.gestionstck.Service.LigneCommandeCImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lignecommandeclient")
public class RestControllerLigneCommandeC {

    @Autowired
    private LigneCommandeCImp ligneCommandeCImp;

    @GetMapping("/all")
    public List<LigneCommandeClient> getallLigneCommandeClient(){
        return ligneCommandeCImp.getAllLigneCommandeClient();
    }

    @PostMapping("/save")
    public LigneCommandeClient addLigneCommandeClient(@RequestBody LigneCommandeClient ligneCommandeClient){
        return ligneCommandeCImp.createLigneCommandeClient(ligneCommandeClient);
    }

    @GetMapping("/getone/{id}")
    public LigneCommandeClient getoneLigneCommandeClient(@PathVariable Long id){
        return ligneCommandeCImp.getLigneCommandeClientById(id);
    }

    @PutMapping("/update/{id}")
    public LigneCommandeClient updateLigneCommandeClient(@PathVariable Long id, @RequestBody LigneCommandeClient ligneCommandeClient){
        LigneCommandeClient ligneCommandeClient1 = ligneCommandeCImp.getLigneCommandeClientById(id);

        if (ligneCommandeClient1 != null){
            ligneCommandeClient.setId(id);
            return ligneCommandeCImp.updateLigneCommandeClient(ligneCommandeClient);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteLigneCommandeClient(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (ligneCommandeCImp.getLigneCommandeClientById(id) == null){
            message.put("etat", "ligne commande client not found");
            return message;
        }
        try {
            ligneCommandeCImp.deleteLigneCommandeClient(id);
            message.put("etat", "ligne commande client deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "ligne commande client not deleted");
            return message;
        }
    }
}
