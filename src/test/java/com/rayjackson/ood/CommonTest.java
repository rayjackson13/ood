package com.rayjackson.ood;

import com.rayjackson.ood.builder.Builder1;
import com.rayjackson.ood.sorttypes.ISort;
import com.rayjackson.ood.sorttypes.SortType;
import com.rayjackson.ood.stategy.SortStrategy;
import com.rayjackson.ood.stategy.Strategy;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommonTest {

    private final String printTime = "It took me %s milliseconds to do %s sort";

    private List<Integer> doTimedSort(ISort obj, SortType type) {
        long timeStart = System.currentTimeMillis();
        List<Integer> result = obj.sort();
        long timeSpent = System.currentTimeMillis() - timeStart;
        System.out.println(String.format(printTime, timeSpent, type));
        return result;
    }

    private void maintenance(Integer[] arr, Integer[] exp, SortType type) {
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> actual = Arrays.asList(arr);
        ISort object = Factory.getSort(actual, type.getType());
        assertEquals(expected, object.getList());
    }

    @Test
    public void testSort1() {
        Integer[] arr= {234, 123, 101, 789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        maintenance(arr, exp, SortType.MERGE_SORT);
    }

    @Test
    public void testSort2() {
        Integer[] array = {234, 123, 101, 789, 101, 107};
        Integer[] expArray = {101, 101, 107, 123, 234, 789};
        maintenance(array, expArray, SortType.QUICK_SORT);
    }

    @Test
    public void testSort3() {
        Integer[] array = {101, 101, 999, 101, 101, 101, 101, 101, 101, 101};
        Integer[] expArray = {101, 101, 101, 101, 101, 101, 101, 101, 101, 999};
        maintenance(array, expArray, SortType.RADIX_SORT);
    }

    @Test
    public void testSort4() {
        Integer[] array = {4, 2, 719823912, 232323, 6666666, 4213};
        Integer[] expArray = {2, 4, 4213, 232323, 6666666, 719823912};
        maintenance(array, expArray, SortType.QUICK_SORT);
    }

    @Test(expected = NullPointerException.class)
    public void testSort5(){
        Integer[] array = {4, 2, 719823912, 232323, 6666666, 4213, null};
        Integer[] expArray = {null, 2, 4, 4213, 232323, 6666666, 719823912};
        maintenance(array, expArray, SortType.RADIX_SORT);
    }

    @Test
    public void testBuilder1(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Builder1 builder1 = new Builder1();
        List<Integer> actual = builder1.build(act1, act2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDirector1(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Director director = Director.getInstance(1, act1, act2);
        List<Integer> actual = director.getResult();
        assertEquals(expected, actual);
    }

    @Test
    public void testDirector2(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Director director = Director.getInstance(2, act1, act2);
        List<Integer> actual = director.getResult();
        assertEquals(expected, actual);
    }

    @Test
    public void testPrototype(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Director director = Director.getInstance(3, act1, act2);
        Director clone = (Director) director.clone();
        List<Integer> actual = clone.getResult();
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleTone(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] arr3 = {709, 1031, 17};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        List<Integer> act3 = Arrays.asList(arr3);
        Director instance = Director.getInstance(3, act1, act2);
        Director instance1 = Director.getInstance(2, act1, act3);

        //AYE! Instance = Instance1!!!

        List<Integer> actual = instance1.getResult();
        actual = instance.getResult();
        assertEquals(expected, actual);
    }


    @Test
    public void testAdapter(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Adapter adapter = new Adapter("Quick and Radix", act1, act2);
        List<Integer> actual = adapter.getDirector().getResult();
        assertEquals(expected, actual);
    }

    @Test
    public void testStrategy(){
        Integer[] arr1 = {234, 123, 101};
        Integer[] arr2 = {789, 101, 107};
        Integer[] exp = {101, 101, 107, 123, 234, 789};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> act1 = Arrays.asList(arr1);
        List<Integer> act2 = Arrays.asList(arr2);
        Strategy strategy = new SortStrategy("quick and shell", act1, act2);
        List<Integer> actual = strategy.sort();
        assertEquals(expected, actual);
    }

}