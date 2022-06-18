package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="inqueringabout")
public class InqueringAbout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inqueringaboutid")
    private int inqueringAboutId ;

    @Column(name="name")
    private String name;

    public InqueringAbout(int inqueringAboutId, String name) {
        this.inqueringAboutId = inqueringAboutId;
        this.name = name;
    }

    public InqueringAbout() {
    }

    public int getInqueringAboutId() {
        return inqueringAboutId;
    }

    public void setInqueringAboutId(int inqueringAboutId) {
        this.inqueringAboutId = inqueringAboutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
