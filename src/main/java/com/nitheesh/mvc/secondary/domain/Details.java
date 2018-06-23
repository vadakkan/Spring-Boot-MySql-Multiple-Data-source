package com.nitheesh.mvc.secondary.domain;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profession;

    public Details() {
        super();
    }

    public Details(String profession) {
        this.profession = profession;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Details [id=" + id + ", Profession=" + profession + "]";
    }

}