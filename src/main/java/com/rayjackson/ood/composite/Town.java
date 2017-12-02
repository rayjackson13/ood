package com.rayjackson.ood.composite;

import java.util.ArrayList;
import java.util.List;

public class Town implements Building{
    private String name;
    private List<Street> streets;

    public Town(){
        streets = new ArrayList<>();
    }

    private Town(String name){
        streets = new ArrayList<>();
        this.name = name;
    }

    private Town(String name, List<Street> streets){
        streets = new ArrayList<>(streets);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStreet(Street street){
        streets.add(street);
    }

    public List<Street> getStreets() {
        return streets;
    }

    @Override
    public Town add(String name) {
        return new Town(name);
    }

    @Override
    public void wreck(String name) {

    }
}
