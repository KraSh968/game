package com.orlov.gameClub.controllers;

import com.orlov.gameClub.models.Iron;
import com.orlov.gameClub.repo.IronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatesController {

    @Autowired
    private IronRepository ironRepository;

    @GetMapping("/iron")
    public String blocMain(Model model) {
        Iterable<Iron> irons = ironRepository.findAllByHalls("STANDARD");
        Iterable<Iron> ironsVip = ironRepository.findAllByHalls("VIP");
        model.addAttribute("irons", irons);
        model.addAttribute("ironsVip", ironsVip);
        return "iron-main";
    }


}
