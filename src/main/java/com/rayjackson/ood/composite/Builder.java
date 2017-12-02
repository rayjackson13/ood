package com.rayjackson.ood.composite;

public class Builder {

    public Town buildTown(String name){
        Town town = new Town();
        return town.add(name);
    }

    public House buildHouse(Town town, Street street, int number){
        return new House(street, number);
    }

    public Street buildStreet(Town town, String name){
        Street street = new Street();
        street.add(name);
        town.addStreet(street);
        return street;
    }
}
