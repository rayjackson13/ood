package com.rayjackson.ood.sorttypes;

import java.util.ArrayList;
import java.util.List;


public class ShellSort implements ISort
{
    private List<Integer> list;

    public ShellSort(List<Integer> list){
        this.list = list;
    }

    // здесь сортировка Шелла
    public List<Integer> sort() {
        List<Integer> result = new ArrayList<Integer>(list);
        int length = result.size();
        int el;
        int k;
        for(int i = length/2; i > 0; i /= 2){
            for(int j = i; j < length; j++){
                el = result.get(j);
                for(k = j; k >= i; k -= i){
                    if(el < result.get(k - i)){
                        result.set(k, result.get(k - i));
                    }else{
                        break;
                    }
                }
                result.set(k, el);
            }
        }



        return result;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

    /* Сортировки:
    4. Быстрая
    7. Поразрядная
    9. Шелла
     */

}
