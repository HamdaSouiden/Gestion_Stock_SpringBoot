package com.example.gestionstck.RestController;

import com.example.gestionstck.Entity.Produits;
import com.example.gestionstck.Service.ProduitServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class RestControllerProduit {

    @Autowired
    private ProduitServiceImp produitServiceImp;

    @GetMapping("/all")
    public List<Produits> getallProduct(){
        return produitServiceImp.getAllProduit();
    }

    @PostMapping("/save")
    public Produits addProduct(@RequestBody Produits produits){
        return produitServiceImp.createProduit(produits);
    }

    @GetMapping("/getone/{id}")
    public Produits getOneProduct(@PathVariable Long id){
        return produitServiceImp.getProduitById(id);
    }

    @PutMapping("/update/{id}")
    public Produits updateProduct(@PathVariable Long id, @RequestBody Produits produits){
        Produits produits1 = produitServiceImp.getProduitById(id);

        if (produits1 != null){
            produits.setId(id);
            return produitServiceImp.updateProduit(produits);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteProduct(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (produitServiceImp.getProduitById(id) == null){
            message.put("etat", "produit not found");
            return message;
        }
        try {
            produitServiceImp.deleteProduit(id);
            message.put("etat", "product deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "product not deleted");
            return message;
        }
    }
}
