package com.orlov.gameClub.models;

import javax.persistence.*;

@Entity
public class Iron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CPU;
    private String video_card;
    private String monitor;
    private String gaming_chair;
    private String headset;
    private String keyboard;

    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    private String halls;


    public Iron() {
    }

    public Iron(String CPU, String video_card, String monitor, String gaming_chair, String headset, String keyboard, String halls) {
        this.CPU = CPU;
        this.video_card = video_card;
        this.monitor = monitor;
        this.gaming_chair = gaming_chair;
        this.headset = headset;
        this.keyboard = keyboard;
        this.halls = halls;
    }

    public Iron(Long id, String CPU, String video_card, String monitor, String gaming_chair, String headset, String keyboard, String halls) {
        this.id = id;
        this.CPU = CPU;
        this.video_card = video_card;
        this.monitor = monitor;
        this.gaming_chair = gaming_chair;
        this.headset = headset;
        this.keyboard = keyboard;
        this.halls = halls;
    }

    public String getHalls() {
        return halls;
    }

    public void setHalls(String halls) {
        this.halls = halls;
    }

    public void setStatus(Hall status) {
        this.hall = status;
    }

    public Hall getStatus() {
        return hall;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setVideo_card(String videoСard) {
        this.video_card = videoСard;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setGaming_chair(String gamingChair) {
        this.gaming_chair = gamingChair;
    }

    public void setHeadset(String headset) {
        this.headset = headset;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public Long getId() {
        return id;
    }

    public String getCPU() {
        return CPU;
    }

    public String getVideo_card() {
        return video_card;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getGaming_chair() {
        return gaming_chair;
    }

    public String getHeadset() {
        return headset;
    }

    public String getKeyboard() {
        return keyboard;
    }
}

