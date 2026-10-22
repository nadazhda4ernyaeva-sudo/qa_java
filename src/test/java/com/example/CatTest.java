package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void getSoundReturnsCorrectString() {
        Cat cat = new Cat(felineMock);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        assertEquals(expectedSound, actualSound, "Кот должен говорить Мяу");
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");


        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood, "Метод getFood должен возвращать список еды от predator");
    }
}
