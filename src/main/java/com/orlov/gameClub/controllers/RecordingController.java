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

@Controller
public class RecordingController {

    @Autowired
    DataRepository dataRepository;

    @Autowired
    PcRepository pcRepository;

    @Autowired
    RecordingRepository recordingRepository;

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    TimeRepository timeRepository;

    @GetMapping("/recording")
    public String recording(Model model) {
        Iterable<Data> data = dataRepository.findAll();
        List<Price> prices = priceRepository.findAllByHalls("STANDARD");
        List<Price> pricesVip = priceRepository.findAllByHalls("VIP");
        List<Time> times = timeRepository.findAll();
        model.addAttribute("times", times);
        model.addAttribute("prices", prices);
        model.addAttribute("pricesVip", pricesVip);
        model.addAttribute("title", "Запись");
        model.addAttribute("data", data);
        return "recording";
    }

    @GetMapping("/complited")
    public String complited(Model model) {

        return "complited";
    }

    @PostMapping("/dataSet")
    public String dataSet(
//            @AuthenticationPrincipal Data data,
            @RequestParam String text, Model model
    ) {


//        Collections.reverse(messages);
        Iterable<Pc> pcs = pcRepository.findAll();
        List<Price> prices = priceRepository.findAllByHalls("STANDARD");
        List<Price> pricesVip = priceRepository.findAllByHalls("VIP");
        List<Time> times = timeRepository.findAll();
        model.addAttribute("times", times);
        model.addAttribute("prices", prices);
        model.addAttribute("pricesVip", pricesVip);
        model.addAttribute("data", text);
        model.addAttribute("pcs", pcs);
        return "dataSet";
    }

    @GetMapping("/dataSet")
    public String setPc(Model model) {
        List<Pc> pcs = pcRepository.findAll();
        List<Price> prices = priceRepository.findAllByHalls("STANDARD");
        List<Price> pricesVip = priceRepository.findAllByHalls("VIP");
        List<Time> times = timeRepository.findAll();
        model.addAttribute("times", times);
        model.addAttribute("prices", prices);
        model.addAttribute("pricesVip", pricesVip);
        model.addAttribute("title", "Запись");
        model.addAttribute("pcs", pcs);
        return "dataSet";
    }



    @PostMapping("/recording")
    public synchronized String recordingSet(
            @AuthenticationPrincipal User user,
            @RequestParam Data day,
            @RequestParam Price price,
            @RequestParam Time time,
            @RequestParam Pc pcs, Model model
    ) {

        List<Recording> recordingsC = recordingRepository.findAll();

        for (Recording recording : recordingsC) {
            if (recording.getData() == day && recording.getTime() == time && recording.getPc() == pcs) {
                model.addAttribute("messageerror", "Это время занято");
                return "redirect:/recording";
            }
        }


        Recording recordings = new Recording(user, pcs, price, day, time);
//        Collections.reverse(messages);
        recordingRepository.save(recordings);

        model.addAttribute("recordings", recordings);
        return "payment";
    }

    @PostMapping("/payment")
    public String payment(
            @RequestParam Long record, Model model
    ) {
        recordingRepository.deleteById(record);

        return "redirect:/recording";
    }





}