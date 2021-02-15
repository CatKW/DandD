package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.alignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alignment")
public class Align {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alignment_id")

    private Integer id;
    private String alignmentName;
    private String alignmentDesc;
    private String alignmentLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlignmentName() {
        return alignmentName;
    }

    public void setAlignmentName(String alignmentName) {
        this.alignmentName = alignmentName;
    }

    public String getAlignmentDesc() {
        return alignmentDesc;
    }

    public void setAlignmentDesc(String alignmentDesc) {
        this.alignmentDesc = alignmentDesc;
    }

    public String getAlignmentLink() {
        return alignmentLink;
    }

    public void setAlignmentLink(String alignmentLink) {
        this.alignmentLink = alignmentLink;
    }
}
