package com.rayjackson.ood.composite;

public class House {

    private Street street;
    private int number;
    private String address;

    public House(Street street, int number){
        this.street = street;
        this.number = number;
        setAddress();
        street.addHouse(this);
    }

    private void setAddress(){
        address = street.getAddress() + " " + number;
    }

    public Street getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }
}
