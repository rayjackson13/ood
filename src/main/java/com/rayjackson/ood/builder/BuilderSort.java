package com.rayjackson.ood.builder;

import com.rayjackson.ood.sorttypes.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class BuilderSort {
    public static List<Integer> sort(List<Integer> x, List<Integer> y){
        List<Integer> result = new ArrayList<>();
        result.addAll(x);
        result.addAll(y);
        MergeSort mergeSort = new MergeSort(result);
        return mergeSort.sort();
    }
}
