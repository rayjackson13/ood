package com.rayjackson.ood.stategy;

import com.rayjackson.ood.Adapter;

import java.util.List;

public class SortStrategy implements Strategy{

    private Adapter adapter;

    public SortStrategy(String name, List<Integer> a, List<Integer> b){
        this.adapter = new Adapter(name, a, b);
    }

    @Override
    public List<Integer> sort() {
        return adapter.getDirector().getResult();
    }
}
