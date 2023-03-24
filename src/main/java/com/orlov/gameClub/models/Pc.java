package com.orlov.gameClub.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int time;

    @ManyToOne
    @JoinColumn(name = "iron")
    private Iron iron;

    @ManyToOne
    @JoinColumn(name = "hall")
    private  Hall hall;

    @OneToMany(mappedBy = "pc")
    private List<Recording> recordings;


    public Pc() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Iron getIron() {
        return iron;
    }

    public void setIron(Iron iron) {
        this.iron = iron;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
