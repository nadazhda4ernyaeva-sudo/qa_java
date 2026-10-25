package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void constructorSetsCorrectManeValue(String sex, boolean expectedHasMane) throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);

        assertEquals(expectedHasMane, lion.doesHaveMane(), "Наличие гривы определено неверно для пола: " + sex);
    }
}


