package com.nitheesh.mvc.primary.domain;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    public Person() {
        super();
    }

    public Person(String name, String country) {
        this.name = name;
        this.country = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return country;
    }

    public void setCity(String city) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person [pid=" + id + ", pName=" + name + ", pCountry=" + country
                + "]";
    }

}