package com.rayjackson.ood;

import com.rayjackson.ood.stategy.Strategy;

import java.util.List;

public class Adapter {
    private Director director;

    public Adapter(int number, List<Integer> x, List<Integer> y) throws IllegalArgumentException {
        if (number < 1 || number > 3) {
            throw new IllegalArgumentException();
        }
        this.director = Director.getInstance(number, x, y);
    }

    public Adapter(String name, List<Integer> x, List<Integer> y) throws IllegalArgumentException {
        switch (name.toLowerCase()) {
            case "quick and radix":
                this.director = Director.getInstance(1, x, y);
                break;
            case "quick and shell":
                this.director = Director.getInstance(2, x, y);
                break;
            case "shell and radix":
                this.director = Director.getInstance(3, x, y);
                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    public Director getDirector() {
        return director;
    }
}
