package com.example.gestionstck.Repository;


import com.example.gestionstck.Entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {
}
