package com.orlov.gameClub.controllers;

import com.orlov.gameClub.models.*;
import com.orlov.gameClub.repo.IronRepository;
import com.orlov.gameClub.repo.MessageRepository;
import com.orlov.gameClub.repo.PriceRepository;
import com.orlov.gameClub.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        model.put("title", "Главная страница");
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "home";
    }

    @PostMapping("/home")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text, Model model
    ) {
        Message message = new Message(text, user);

        messageRepository.save(message);

        List<Message> messages = messageRepository.findAll();

//        Collections.reverse(messages);

        model.addAttribute("messages", messages);

        return "home";
    }


    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("title", "Главная страница");
        return "user";
    }


    @GetMapping("/price")
    public String price(Model model) {
        Iterable<Price> prices = priceRepository.findAll();
        model.addAttribute("prices", prices);
        return "price";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }
}
