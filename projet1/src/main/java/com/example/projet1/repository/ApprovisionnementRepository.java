package com.example.projet1.repository;

import com.example.projet1.model.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer> {
}
