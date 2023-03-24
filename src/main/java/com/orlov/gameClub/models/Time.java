package com.orlov.gameClub.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int hour;

    @OneToMany(mappedBy = "time")
    private List<Recording> recordings;

    public Time() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }
}
