package com.rayjackson.ood.sorttypes;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort implements ISort {

    private List<Integer> list;
    private static final Random random = new Random();

    public QuickSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

    private void sort(List<Integer> act, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            int pivotValue = list.get(pivot);
            while (left <= right) {
                while (left <= to && pivotValue >= list.get(left)) {
                    left++;
                }
                while (right > from && pivotValue < list.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1);
            sort(list, right + 1, to);
        }
    }

    public List<Integer> sort() {
        sort(this.list, 0, list.size() - 1);
        return list;
    }

}
