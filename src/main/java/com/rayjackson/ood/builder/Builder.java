package com.rayjackson.ood.builder;

import java.util.List;

public interface Builder {
    List<Integer> sortFirst(List<Integer> x);
    List<Integer> sortSecond(List<Integer> x);
    List<Integer> build(List<Integer> x, List<Integer> y);

    //мост абстракция - строитель, реализация - сортировка
}
