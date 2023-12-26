package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.Client;
import com.example.gestionstck.Service.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/client")
public class RestControllerClient {
    @Autowired
    private ClientServiceImp clientServiceImp;

    @GetMapping("/all")
    public List<Client> getallClients(){
        return clientServiceImp.getAllClient();
    }

    @PostMapping("/save")
    public Client addClient(@RequestBody Client client){
        return clientServiceImp.createClient(client);
    }

    @GetMapping("/getone/{id}")
    public Client getOneClient(@PathVariable Long id){
        return clientServiceImp.getClientById(id);
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        Client client1 = clientServiceImp.getClientById(id);
        if (client1 != null){
            client.setId(id);
            return clientServiceImp.updateClient(client);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteClient(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (clientServiceImp.getClientById(id) == null){
            message.put("etat", "client not found");
            return message;
        }
        try {
            clientServiceImp.deleteClient(id);
            message.put("etat", "client deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "client not deleted");
            return message;
        }
    }
}
