package com.rayjackson.ood.builder;

import com.rayjackson.ood.Factory;

import java.util.List;

public class Builder1 implements Builder {

    @Override
    public List<Integer> sortFirst(List<Integer> x) {
        return Factory.getSort(x, "quick").getList();

    }

    @Override
    public List<Integer> sortSecond(List<Integer> x) {
        return Factory.getSort(x, "radix").getList();
    }

    @Override
    public List<Integer> build(List<Integer> x, List<Integer> y) {
        x = sortFirst(x);
        y = sortSecond(y);
        return BuilderSort.sort(x, y);
    }
}
