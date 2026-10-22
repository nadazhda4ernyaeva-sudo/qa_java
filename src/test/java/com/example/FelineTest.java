package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsCorrectFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood, "Метод eatMeat должен возвращать рацион хищника");
    }

    @Test
    public void getFamilyReturnsCorrectString() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily, "Семейство должно быть Кошачьи");
    }

    @Test
    public void getKittensWithoutArgumentsReturnsOne() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;

        int actualKittensCount = feline.getKittens();

        assertEquals(expectedKittensCount, actualKittensCount, "По умолчанию количество котят должно быть 1");
    }

    // Параметризованный тест для метода с аргументом
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 100})
    public void getKittensWithArgumentReturnsCorrectCount(int kittensCount) {
        Feline feline = new Feline();

        int actualKittensCount = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittensCount, "Метод должен возвращать переданное количество котят");
    }
}
