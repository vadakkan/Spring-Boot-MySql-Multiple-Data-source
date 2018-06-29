package com.nitheesh.mvc.primary.domain;


import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Country")
@Table
@Data
public   class Country {

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    private String name;


}