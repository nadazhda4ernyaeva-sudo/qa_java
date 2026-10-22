package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    // Оставляем поле, но теперь не создаем объект сразу
    private final Feline feline;

    // Добавляем Feline в параметры конструктора
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline; // Сохраняем переданную зависимость

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
