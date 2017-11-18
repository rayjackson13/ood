package com.rayjackson.ood.sorttypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rayjackson on 09.09.2017.
 */
public class RadixSort implements ISort {
    private List<Integer> list;

    public RadixSort(List<Integer> list) {
        this.list = list;
    }

    private int getMax() {
        int max = 0;
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    //поразрядная сортировка
    public List<Integer> sort() {
        List<Integer> result = new ArrayList<Integer>(list);

        //defining range of the largest int
        int max = getMax();
        List<Integer> listCopy = new ArrayList<Integer>(list);
        int exp = 1;
        int bucket[] = new int[10];

        while(max / exp > 0) {
            int digits[] = new int[10];
            for(Integer i : listCopy){
                digits[(i/exp)%10]++;
            }
            for(int i = 1; i < 10; i++){
                digits[i] += digits[i - 1];
            }
            for(int i = listCopy.size() - 1; i >= 0; i--){
                bucket[--digits[(listCopy.get(i)/exp)%10]] = listCopy.get(i);
            }
            for(int i = 0; i < listCopy.size(); i++){
                listCopy.set(i, bucket[i]);
            }
            exp *= 10;
        }
        return listCopy;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
