package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Predator predator;
    private final ParentingAnimal parentingAnimal;

    public Lion(String sex, Predator predator, ParentingAnimal parentingAnimal) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.predator = predator;
        this.parentingAnimal = parentingAnimal;
    }

    public int getKittens() {
        return parentingAnimal.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
