package com.orlov.gameClub.service;


import com.orlov.gameClub.models.Role;
import com.orlov.gameClub.models.User;
import com.orlov.gameClub.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

//    public boolean saveUser(User user) {
//        User userFromDB = userRepo.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }

}