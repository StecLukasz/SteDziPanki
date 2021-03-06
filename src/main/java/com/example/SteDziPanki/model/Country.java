package com.example.SteDziPanki.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<City> cities = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Continent continent;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Trip> tripSet = new HashSet<>();


    public Country(String name) {
    }

    public Country() {
    }

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
