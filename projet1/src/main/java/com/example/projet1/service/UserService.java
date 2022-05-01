package com.example.projet1.service;

import com.example.projet1.model.User;
import com.example.projet1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    //enregistrer un utilisation
    public void saveUser(User user) {
        userRepository.save(user);
    }

    //afficher liste de utilisateurs
    public List<User> showUser() {
        return userRepository.findAll();
    }

    //supprimer un utilisateur
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
