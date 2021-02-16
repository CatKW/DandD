package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.races;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "races")
public class Races {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "race_id")

    private Integer id;
    private String raceName;
    private String raceDescription;
    private String raceDetailUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    public void setRaceDescription(String raceDescription) {
        this.raceDescription = raceDescription;
    }

    public String getRaceDetailUrl() {
        return raceDetailUrl;
    }

    public void setRaceDetailUrl(String raceDetailUrl) {
        this.raceDetailUrl = raceDetailUrl;
    }
    
}
