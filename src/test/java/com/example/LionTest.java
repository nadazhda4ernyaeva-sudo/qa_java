package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline felineMock;


    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void constructorSetsCorrectManeValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane(), "Наличие гривы определено неверно для пола: " + sex);
    }


    @Test
    public void constructorThrowsExceptionOnInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", felineMock);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expectedMessage, exception.getMessage(), "Текст ошибки не совпадает");
    }


    @Test
    public void getKittensReturnsCorrectCount() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        int actualKittens = lion.getKittens();

        assertEquals(1, actualKittens, "Метод getKittens должен возвращать значение из Feline");
    }


    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Метод getFood должен возвращать рацион хищника из Feline");
    }
}
