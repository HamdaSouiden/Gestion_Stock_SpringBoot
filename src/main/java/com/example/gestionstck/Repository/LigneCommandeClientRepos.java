package com.example.gestionstck.Repository;


import com.example.gestionstck.Entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepos extends JpaRepository<LigneCommandeClient,Long> {
}
