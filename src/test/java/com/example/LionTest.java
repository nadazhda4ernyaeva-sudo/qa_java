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
    Feline felineMock; // Мокаем Feline, чтобы изолировать Lion

    // 1 и 2. Параметризованный тест для проверки веток "Самец" и "Самка"
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void constructorSetsCorrectManeValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane(), "Наличие гривы определено неверно для пола: " + sex);
    }

    // 3. Тест на ветку исключения (некорректный пол)
    @Test
    public void constructorThrowsExceptionOnInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", felineMock);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expectedMessage, exception.getMessage(), "Текст ошибки не совпадает");
    }

    // 4. Тест метода getKittens() с использованием мока
    @Test
    public void getKittensReturnsCorrectCount() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        int actualKittens = lion.getKittens();

        assertEquals(1, actualKittens, "Метод getKittens должен возвращать значение из Feline");
    }

    // 5. Тест метода getFood() с использованием мока
    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Метод getFood должен возвращать рацион хищника из Feline");
    }
}
