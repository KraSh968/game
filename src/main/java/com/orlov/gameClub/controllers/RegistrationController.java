package com.orlov.gameClub.controllers;


//import com.orlov.gameClub.models.ERole;

import com.orlov.gameClub.models.Role;
import com.orlov.gameClub.models.User;
import com.orlov.gameClub.repo.RoleRepository;
import com.orlov.gameClub.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    Long l1 = Long.valueOf(1);

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    public Role registrationq() {
        roleRepository.findByName("USER");
        return new Role();
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        Role roleUser = roleRepository.findByName("USER");
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }




        user.setActive(true);
//        user.setRoles(Collections.singleton(ERole.USER));

//        roleUser.toString();
//
//        user.setRoles(roleUser.forEach(role -> role.getId()));

//        user.setRoles(new Role(1L,"USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";
    }
}
