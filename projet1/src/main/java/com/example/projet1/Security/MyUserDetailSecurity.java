package com.example.projet1.Security;

import com.example.projet1.model.User;
import com.example.projet1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailSecurity implements UserDetailsService {

    @Autowired
    private UserRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User utilisateurModel = utilisateurRepository.findBynom(username);
        if (utilisateurModel == null)
            throw new UsernameNotFoundException("utilisateur introuvable");
        return new UserPrincipal(utilisateurModel);
    }
}
