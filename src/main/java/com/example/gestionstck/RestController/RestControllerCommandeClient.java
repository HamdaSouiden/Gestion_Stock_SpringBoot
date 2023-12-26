package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.CommandeClient;
import com.example.gestionstck.Service.CommandeClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commandeclient")
public class RestControllerCommandeClient {

    @Autowired
    private CommandeClientServiceImp commandeClientServiceImp;

    @GetMapping("/all")
    public List<CommandeClient> getallCommandeClient(){
        return commandeClientServiceImp.getAllCommandeClient();
    }

    @PostMapping("/save")
    public CommandeClient addCommandeClient(@RequestBody CommandeClient commandeClient){
        return commandeClientServiceImp.createCommandeClient(commandeClient);
    }

    @GetMapping("/getone/{id}")
    public CommandeClient getOneCommandeClient(@PathVariable Long id){
        return commandeClientServiceImp.getCommandeClientById(id);
    }

    @PutMapping("/update/{id}")
    public CommandeClient updateCommandeClient(@PathVariable Long id, @RequestBody CommandeClient commandeClient){
        CommandeClient commandeClient1 = commandeClientServiceImp.getCommandeClientById(id);

        if (commandeClient1 != null){
            commandeClient.setId(id);
            return commandeClientServiceImp.updateCommandeClient(commandeClient);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteCommandeClient(@PathVariable Long id){
        HashMap<String, String> messsage = new HashMap<>();

        if (commandeClientServiceImp.getCommandeClientById(id) == null){
            messsage.put("etat", "Commande client not found");
            return messsage;
        }
        try {
            commandeClientServiceImp.deleteCommandeClient(id);
            messsage.put("etat", "Commande client deleted");
            return messsage;
        }catch (Exception e){
            messsage.put("etat", "Commande client not deleted");
            return messsage;
        }
    }
}
