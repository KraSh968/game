package com.orlov.gameClub.models;

import javax.persistence.*;

@Entity
public class Recording {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "pc")
    private Pc pc;

    @ManyToOne
    @JoinColumn(name = "price")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "data")
    private Data data;

    @ManyToOne
    @JoinColumn(name = "time")
    private Time time;


    public Recording(Pc pc, Data data) {
        this.pc = pc;
        this.data = data;
    }

    public Recording(Pc pc, Price price, Data data) {
        this.pc = pc;
        this.price = price;
        this.data = data;
    }

    public Recording(User userId, Pc pc, Data data) {
        this.userId = userId;
        this.pc = pc;
        this.data = data;
    }

    public Recording(User userId, Pc pc, Price price, Data data, Time time) {
        this.userId = userId;
        this.pc = pc;
        this.price = price;
        this.data = data;
        this.time = time;
    }

    public Recording(User userId, Pc pc, Price price, Data data) {
        this.userId = userId;
        this.pc = pc;
        this.price = price;
        this.data = data;
    }

    public Recording() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public Pc getPc() {
        return pc;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
