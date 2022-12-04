package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ColourTest {

    @Test
    void Test_red() {
        Colour colour1 = new Colour(1.0f, 1.0f, 1.0f);
        Assertions.assertEquals(255, colour1.getRed());
    }

    @Test
    public void Test_red_correct_values() {

        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour = new Colour(2.0f, 1.0f, 1.0f);
        });
        Assertions.assertEquals("Red float value must be above 0 and below 1", exception1.getMessage());

        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour = new Colour(-1f, 1.0f, 1.0f);
        });
        Assertions.assertEquals("Red float value must be above 0 and below 1", exception2.getMessage());
    }

}