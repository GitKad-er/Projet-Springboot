package com.example.projet1.repository;

import com.example.projet1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

    User findBynom(String nom);

}
