package com.orlov.gameClub.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rate;
    private String day;
    private int hour;
    private int price;
    private String halls;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    @OneToMany(mappedBy = "price")
    private List<Recording> recordings;


    public String getHalls() {
        return halls;
    }

    public void setHalls(String halls) {
        this.halls = halls;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Price() {
    }



    public Price(String rate, String day, int hour, int price, String halls) {
        this.rate = rate;
        this.day = day;
        this.hour = hour;
        this.price = price;
        this.halls = halls;
    }

    public Price(Long id, String rate, String day, int hour, int price, String halls) {
        this.id = id;
        this.rate = rate;
        this.day = day;
        this.hour = hour;
        this.price = price;
        this.halls = halls;
    }

    public String getHall() {
        return halls;
    }

    public void setHall(String halls) {
        this.halls = halls;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getRate() {
        return rate;
    }

    public String getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getPrice() {
        return price;
    }
}
