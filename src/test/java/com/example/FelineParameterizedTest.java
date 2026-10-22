package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 100})
    public void getKittensWithArgumentReturnsCorrectCount(int kittensCount) {
        Feline feline = new Feline();

        int actualKittensCount = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittensCount, "Метод должен возвращать переданное количество котят");
    }
}
