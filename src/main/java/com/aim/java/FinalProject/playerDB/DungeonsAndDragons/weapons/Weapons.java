package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.weapons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weapons")
public class Weapons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weapons_id")

    private Integer id;
    private String weaponsType;
    private String weaponsName;
    private String weaponsDamage;
    private Integer weaponsWeight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeaponsType() {
        return weaponsType;
    }

    public void setWeaponsType(String weaponsType) {
        this.weaponsType = weaponsType;
    }

    public String getWeaponsName() {
        return weaponsName;
    }

    public void setWeaponsName(String weaponsName) {
        this.weaponsName = weaponsName;
    }

    public String getWeaponsDamage() {
        return weaponsDamage;
    }

    public void setWeaponsDamage(String weaponsDamage) {
        this.weaponsDamage = weaponsDamage;
    }

    public Integer getWeaponsWeight() {
        return weaponsWeight;
    }

    public void setWeaponsWeight(Integer weaponsWeight) {
        this.weaponsWeight = weaponsWeight;
    }
}
