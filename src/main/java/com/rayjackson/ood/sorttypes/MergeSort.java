package com.rayjackson.ood.sorttypes;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements ISort {
    private List<Integer> list;
    public MergeSort(List<Integer> list){
        this.list = list;
    }

    private void merge(List<Integer> list, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Integer> temp1 = new ArrayList<>();
        for(int i = 0; i < n1; i++){
            temp1.add(list.get(left + i));
        }

        List<Integer> temp2 = new ArrayList<>();
        for(int i = 0; i < n2; i++){
            temp2.add(list.get(middle + 1 + i));
        }

        int i = 0;
        int j = 0;

        int k = left;
        while(i < n1 && j <n2){
            if(temp1.get(i) <= temp2.get(j)){
                list.set(k, temp1.get(i));
                i++;
            }else{
                list.set(k, temp2.get(j));
                j++;
            }
            k++;
        }

        while(i < n1){
            list.set(k, temp1.get(i));
            i++;
            k++;
        }

        while(j < n2){
            list.set(k, temp2.get(j));
            j++;
            k++;
        }
    }

    private void sort(List<Integer> list, int left, int right) {
        if(left < right){
            int middle = (left + right)/2;
            sort(list, left, middle);
            sort(list, middle + 1, right);
            merge(list, left, middle, right);
        }
    }
    @Override
    public List<Integer> sort() {
        List<Integer> copy = new ArrayList<>(list);
        int left = 0;
        int right = copy.size() - 1;
        sort(copy, left, right);
        return copy;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
