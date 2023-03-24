package com.orlov.gameClub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "hall")
    private List<Iron> irons;
    @JsonIgnore
    @OneToMany(mappedBy = "hall")
    private List<Price> prices;
    @OneToMany(mappedBy = "hall")
    private List<Pc> pc;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Iron> getIrons() {
        return irons;
    }

    public void setIrons(List<Iron> irons) {
        this.irons = irons;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Pc> getPc() {
        return pc;
    }

    public void setPc(List<Pc> pc) {
        this.pc = pc;
    }

    public Hall() {
    }

    public Hall(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
