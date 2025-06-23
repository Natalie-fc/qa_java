package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;


    @Test
    public void getKittensReturnsMockedValue() throws Exception {
        when(feline.getKittens()).thenReturn(4);
       Lion lion = new Lion("Самец", feline);
        assertEquals(4, lion.getKittens());
    }

    @Test
    public void getFoodReturnsMockedList() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
           Lion lion = new Lion("Самка", feline);
            assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Нечто", feline);
    }

}
