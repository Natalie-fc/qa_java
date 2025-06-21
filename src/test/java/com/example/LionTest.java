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
    Predator predator;

    @Mock
    ParentingAnimal parentingAnimal;

    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
       Lion lion = new Lion("Самец", predator, parentingAnimal);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
       Lion lion = new Lion("Самка", predator, parentingAnimal);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getKittensReturnsMockedValue() throws Exception {
        when(parentingAnimal.getKittens()).thenReturn(4);
       Lion lion = new Lion("Самец", predator, parentingAnimal);
        assertEquals(4, lion.getKittens());
    }

    @Test
    public void getFoodReturnsMockedList() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
           Lion lion = new Lion("Самка", predator, parentingAnimal);
            assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Нечто", predator, parentingAnimal);
    }

}
