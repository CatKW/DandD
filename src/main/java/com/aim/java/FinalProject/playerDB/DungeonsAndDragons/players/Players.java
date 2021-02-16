package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.players;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.alignment.Alignment;
import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.armor.Armors;
import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.playerclass.PlayerClass;
import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.races.Races;
import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.stats.Stats;
import com.aim.java.FinalProject.playerDB.DungeonsAndDragons.weapons.Weapons;

@Entity
@Table(name = "player")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")

    private Integer id;
    private String firstName;
    private String lastName;
    private String characterName;

    @ManyToOne
    @JoinColumn(name = "playerclass_id", nullable = false)
    private PlayerClass playerClass;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Races races;

 

    @ManyToOne
    @JoinColumn(name = "armor_id", nullable = false)
    private Armors armors;

    @ManyToOne
    @JoinColumn(name = "weapons_id", nullable = false)
    private Weapons weapons;

    @ManyToOne
    @JoinColumn(name = "alignment_id", nullable = false)
    private Alignment alignment;

    @ManyToMany
    @JoinTable(name = "player_stats", joinColumns = @JoinColumn (name = "player_id"), inverseJoinColumns = @JoinColumn(name = "stats_id"))
    private List<Stats> stats;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public Races getRaces() {
        return races;
    }

    public void setRaces(Races races) {
        this.races = races;
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

}
