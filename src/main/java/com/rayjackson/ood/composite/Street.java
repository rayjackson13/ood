package com.rayjackson.ood.composite;

import java.util.ArrayList;
import java.util.List;

public class Street implements Building{
    private List<House> houses;
    private String name;
    private String address;

    public Street(){
        houses = new ArrayList<>();
    }

    private Street(String name){
        houses = new ArrayList<>();
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

//    private void setAddress() {
//        this.address = town + ", " + name;
//    }

    public void addHouse(House house){
        houses.add(house);
    }

    public void wreckHouse(House house){
        houses.remove(house);
    }

    public List<House> getHouses(){
        return houses;
    }

    @Override
    public Street add(String name) {
        return new Street(name);
    }

    @Override
    public void wreck(String name) {

    }
}
