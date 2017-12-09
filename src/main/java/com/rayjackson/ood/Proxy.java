package com.rayjackson.ood;

import com.rayjackson.ood.stategy.Strategy;

import java.util.List;

public class Proxy{
    private Director director;

    public Proxy(int number, List<Integer> x, List<Integer> y){
        if(number < 1 || number > 3){
            throw new IllegalArgumentException("No such builder.");
        }
        director = Director.getInstance(number, x, y);
    }

    public List<Integer> getResult() {
        return director.getResult();
    }
}
