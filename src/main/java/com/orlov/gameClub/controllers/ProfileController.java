package com.orlov.gameClub.controllers;

import com.orlov.gameClub.models.Recording;
import com.orlov.gameClub.models.User;
import com.orlov.gameClub.repo.RecordingRepository;
import com.orlov.gameClub.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecordingRepository recordingRepository;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        Long userId = user.getId();
        Iterable<Recording> recordings = recordingRepository.findAllByUserId(user);
        model.addAttribute("recordings", recordings);
        model.addAttribute("title", "Главная страница");
        return "profile";
    }


    @PostMapping("/editName")
    public String editName(@AuthenticationPrincipal User user,
                           @RequestParam String newName, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(newName);
        Iterable<User> users = userRepository.findAll();
        if (userFromDb != null) {
            model.put("messageerror", "User exists!");
            model.put("user", user);
            model.put("users", users);
            return "profile";
        }
//        User user1 = new User(user.getId(),newName);
        user.setUsername(newName);
        userRepository.save(user);

        return "redirect:/profile";
    }

}
