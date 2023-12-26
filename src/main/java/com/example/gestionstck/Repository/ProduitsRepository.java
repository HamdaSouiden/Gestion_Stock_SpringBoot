package com.example.gestionstck.Repository;


import com.example.gestionstck.Entity.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
}
