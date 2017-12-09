package com.rayjackson.ood;

import java.util.Collections;
import java.util.List;

public class Decorator implements IDecorator{
    @Override
    public int findMax(List<Integer> list) {
        return Collections.max(list);
    }

    @Override
    public int findMin(List<Integer> list) {
        return Collections.min(list);
    }
}
interface IDecorator{
    int findMax(List<Integer> list);
    int findMin(List<Integer> list);
}
