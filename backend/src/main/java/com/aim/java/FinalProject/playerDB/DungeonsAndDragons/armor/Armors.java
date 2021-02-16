package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.armor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armor")
public class Armors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "armor_id")

    private Integer id;
    private String armorTypes;
    private String armorNames;
    private Integer armorClasses;
    private String acModifiers;
    private Integer armorWeights;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArmorTypes() {
        return armorTypes;
    }

    public void setArmorTypes(String armorTypes) {
        this.armorTypes = armorTypes;
    }

    public String getArmorNames() {
        return armorNames;
    }

    public void setArmorNames(String armorNames) {
        this.armorNames = armorNames;
    }

    public Integer getArmorClasses() {
        return armorClasses;
    }

    public void setArmorClasses(Integer armorClasses) {
        this.armorClasses = armorClasses;
    }

    public String getAcModifiers() {
        return acModifiers;
    }

    public void setAcModifiers(String acModifiers) {
        this.acModifiers = acModifiers;
    }

    public Integer getArmorWeights() {
        return armorWeights;
    }

    public void setArmorWeights(Integer armorWeights) {
        this.armorWeights = armorWeights;
    }
}
