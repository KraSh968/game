package com.orlov.gameClub.controllers;

import com.orlov.gameClub.models.*;
import com.orlov.gameClub.repo.*;
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
public class AdminController {

    @Autowired
    private IronRepository ironRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal User user, Model model) {
        if(user.getRoles().getId() == 1) {
            return "redirect:/profile";
        }
        else {
            model.addAttribute("title", "Главная страница");
            Iterable<Iron> irons = ironRepository.findAllByHalls("STANDARD");
            Iterable<Iron> ironsVip = ironRepository.findAllByHalls("VIP");
            Iterable<Hall> halls = hallRepository.findAll();
            Iterable<Price> prices = priceRepository.findAll();
            Iterable<User> users = userRepository.findAll();
            model.addAttribute("irons", irons);
            model.addAttribute("ironsVip", ironsVip);
            model.addAttribute("prices", prices);
            model.addAttribute("halls", halls);
            model.addAttribute("users", users);
            return "admin";
        }
    }

    @GetMapping("/addPrice")
    public String addPrice(Model model) {
        Iterable<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        return "addPrice";
    }

    @GetMapping("/deletedPrice")
    public String deletedPrice(Model model) {
        Iterable<Price> prices = priceRepository.findAll();
        model.addAttribute("prices", prices);
        return "deletedPrice";
    }

    @GetMapping("/changePrice")
    public String changePrice(Model model) {
        Iterable<Price> prices = priceRepository.findAll();
        Iterable<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        model.addAttribute("prices", prices);
        return "changePrice";
    }


    @PostMapping("/addPrice")
    public String addPrice(@RequestParam String rate,
                           @RequestParam String day,
                           @RequestParam int hour,
                           @RequestParam int price,
                           @RequestParam String hall, Map<String, Object> model) {

//        List<Hall> halls = hallRepository.findAllByName(hall);

        Price addPrice = new Price(rate, day, hour, price, hall);

        priceRepository.save(addPrice);
        Iterable<Price> prices = priceRepository.findAll();
        Iterable<Iron> irons = ironRepository.findAllByHallName("STANDARD");
        Iterable<Iron> ironsVip = ironRepository.findAllByHallName("VIP");

        model.put("prices", prices);
        model.put("irons", irons);
        model.put("ironsVip", ironsVip);
        return "redirect:/admin";
    }


    @PostMapping("/changePrice")
    public String changePrice(@RequestParam long id,
                              @RequestParam String rate,
                              @RequestParam String day,
                              @RequestParam int hour,
                              @RequestParam int price,
                              @RequestParam String hall, Map<String, Object> model) {

        Price changePrice = new Price(id, rate, day, hour, price, hall);
        priceRepository.save(changePrice);
        Iterable<Price> prices = priceRepository.findAll();
        model.put("prices", prices);

        return "redirect:/admin";
    }

    @PostMapping("/deletedPrice")
    public String deletedPrice(@RequestParam long id, Map<String, Object> model) {

        priceRepository.deleteById(id);
        Iterable<Price> prices = priceRepository.findAll();
        model.put("prices", prices);

        return "redirect:/admin";
    }

    @GetMapping("/addIron")
    public String addIron(Model model) {
        Iterable<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        return "addIron";
    }


    @PostMapping("/addIron")
    public String addIron(@RequestParam String CPU,
                          @RequestParam String video_card,
                          @RequestParam String monitor,
                          @RequestParam String gaming_chair,
                          @RequestParam String headset,
                          @RequestParam String keyboard,
                          @RequestParam String hall, Map<String, Object> model) {

//        List<Hall> halls = hallRepository.findAllByName(hall);

        Iron addIron = new Iron(CPU, video_card, monitor, gaming_chair, headset, keyboard, hall);

        ironRepository.save(addIron);
        Iterable<Iron> irons = ironRepository.findAll();

        model.put("irons", irons);

        return "redirect:/admin";
    }


    @GetMapping("/deletedIron")
    public String deletedIron(Model model) {
        Iterable<Iron> irons = ironRepository.findAll();
        model.addAttribute("irons", irons);
        return "deletedIron";
    }

    @PostMapping("/deletedIron")
    public String deletedIron(@RequestParam long id, Map<String, Object> model) {

        ironRepository.deleteById(id);
        Iterable<Iron> irons = ironRepository.findAll();
        model.put("irons", irons);

        return "redirect:/admin";
    }

    @GetMapping("/changeIron")
    public String changeIron(Model model) {
        Iterable<Iron> irons = ironRepository.findAll();
        Iterable<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        model.addAttribute("irons", irons);
        return "changeIron";
    }

    @PostMapping("/changeIron")
    public String changeIron(@RequestParam long id,
                              @RequestParam String CPU,
                              @RequestParam String video_card,
                              @RequestParam String monitor,
                              @RequestParam String gaming_chair,
                              @RequestParam String headset,
                              @RequestParam String keyboard,
                              @RequestParam String hall, Map<String, Object> model) {

        Iron changeIron = new Iron(id, CPU, video_card, monitor, gaming_chair, headset, keyboard, hall);
        ironRepository.save(changeIron);
        Iterable<Iron> irons = ironRepository.findAll();
        model.put("irons", irons);

        return "redirect:/admin";
    }

    @GetMapping("/editUser")
    public String editUser(Model model) {
        Iterable<User> users = userRepository.findAll();
        Iterable<Role> roles = roleRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam long id,
                             @RequestParam String role, Map<String, Object> model) {


        Role roles = roleRepository.findByName(role);
        User users = userRepository.findById(id).get();

        users.setRoles(roles);

        userRepository.save(users);


        model.put("users", users);

        return "redirect:/admin";
    }


}
