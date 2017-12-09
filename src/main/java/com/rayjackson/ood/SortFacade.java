package com.rayjackson.ood;

import java.util.List;

public class SortFacade {
    public List<Integer> sort(List<Integer> l1, List<Integer> l2, int builderNumber){
        Director director = Director.getInstance(builderNumber, l1, l2);
        List<Integer> result = director.getResult();
        System.out.println(director.findMax(result));
        System.out.println(director.findMin(result));
        System.out.println(result);
        return result;
    }
}
