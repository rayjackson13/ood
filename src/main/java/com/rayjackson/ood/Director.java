package com.rayjackson.ood;

import com.rayjackson.ood.builder.Builder1;
import com.rayjackson.ood.builder.Builder2;
import com.rayjackson.ood.builder.Builder3;

import java.io.*;
import java.util.List;

public class Director extends Decorator implements Serializable, IPrototype{
    private static Director director;
    private List<Integer> result;

    private Director(int builderNumber, List<Integer> a, List<Integer> b) {
        switch (builderNumber) {
            case 1:
                Builder1 builder1 = new Builder1();
                result = builder1.build(a, b);
                break;
            case 2:
                Builder2 builder2 = new Builder2();
                result = builder2.build(a, b);
                break;
            case 3:
                Builder3 builder3 = new Builder3();
                result = builder3.build(a, b);
                break;
            default:
                break;
        }
    }

    public List<Integer> getResult() {
        return result;
    }

    @Override
    public Object clone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Director getInstance(int builderNumber, List<Integer> a, List<Integer> b) {
        if (director == null) {
            director = new Director(builderNumber, a, b);
        }
        return director;
    }

    @Override
    public int findMax(List<Integer> list) {
        return super.findMax(list);
    }

    @Override
    public int findMin(List<Integer> list) {
        return super.findMin(list);
    }

    //фасад, прокси, цепочка, наблюдатель
}
