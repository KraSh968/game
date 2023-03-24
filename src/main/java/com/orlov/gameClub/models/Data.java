package com.orlov.gameClub.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int day;

    @OneToMany(mappedBy = "data")
    private List<Recording> recordings;

    public Data() {
    }

    public Data(Long id, int day, List<Recording> recordings) {
        this.id = id;
        this.day = day;
        this.recordings = recordings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }
}
