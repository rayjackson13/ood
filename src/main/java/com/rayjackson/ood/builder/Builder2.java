package com.rayjackson.ood.builder;

import com.rayjackson.ood.Factory;
import com.rayjackson.ood.sorttypes.ISort;
import com.rayjackson.ood.sorttypes.QuickSort;
import com.rayjackson.ood.sorttypes.ShellSort;

import java.util.List;

public class Builder2 implements Builder {

    @Override
    public List<Integer> sortFirst(List<Integer> x) {
        return Factory.getSort(x, "quick").getList();

    }

    @Override
    public List<Integer> sortSecond(List<Integer> x) {
        return Factory.getSort(x, "shell").getList();
    }

    @Override
    public List<Integer> build(List<Integer> x, List<Integer> y) {
        x = sortFirst(x);
        y = sortSecond(y);
        return BuilderSort.sort(x, y);
    }
}
