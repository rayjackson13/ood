package com.rayjackson.ood;

import com.rayjackson.ood.sorttypes.*;

import java.util.List;

/**
 * Created by rayjackson on 30.09.2017.
 */
public class Factory {
    public static ISort getSort(List<Integer> list, String sort){
        switch (sort){
            case "quick":
                QuickSort quickSort = new QuickSort(list);
                return new QuickSort(quickSort.sort());
            case "radix":
                RadixSort radixSort = new RadixSort(list);
                return new RadixSort(radixSort.sort());
            case "shell":
                ShellSort shellSort = new ShellSort(list);
                return new ShellSort(shellSort.sort());
            case "merge":
                MergeSort mergeSort = new MergeSort(list);
                return new MergeSort(mergeSort.sort());
            default:
                throw new IllegalArgumentException("Only 'quick', 'radix' and 'shell'");
        }
    }
}
