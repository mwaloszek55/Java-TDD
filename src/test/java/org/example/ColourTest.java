package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ColourTest {

    @Test
    void Test_red() {
        Colour colour1 = new Colour(1.0f, 0f, 0f);
        Assertions.assertEquals(255, colour1.getRed());
        Colour colour2 = new Colour(255);
        Assertions.assertEquals(255, colour2.getRed());
    }

    @Test
    void Test_green() {
        Colour colour1 = new Colour(0f, 1.0f, 0f);
        Assertions.assertEquals(255, colour1.getGreen());
        Colour colour2 = new Colour(65280);
        Assertions.assertEquals(255, colour2.getGreen());
    }
    @Test
    void Test_blue() {
        Colour colour1 = new Colour(0f, 0f, 1.0f);
        Assertions.assertEquals(255, colour1.getBlue());
        Colour colour2 = new Colour(16711680);
        Assertions.assertEquals(255, colour2.getBlue());
    }


    @Test
    void Test_red_correct_values() {

        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour1 = new Colour(2.0f, 1.0f, 1.0f);
        });
        Assertions.assertEquals("Red float value must be above 0 and below 1", exception1.getMessage());

        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour2 = new Colour(-1.0f, 1.0f, 1.0f);
        });
        Assertions.assertEquals("Red float value must be above 0 and below 1", exception2.getMessage());
    }


    @Test
    void Test_green_correct_values() {

        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour1 = new Colour(1.0f, 2.0f, 1.0f);
        });
        Assertions.assertEquals("Green float value must be above 0 and below 1", exception1.getMessage());

        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour2 = new Colour(1.0f, -1.0f, 1.0f);
        });
        Assertions.assertEquals("Green float value must be above 0 and below 1", exception2.getMessage());
    }

    @Test
    public void Test_blue_correct_values() {

        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour1 = new Colour(1.0f, 1.0f, 1.2f);
        });
        Assertions.assertEquals("Blue float value must be above 0 and below 1", exception1.getMessage());

        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour2 = new Colour(1.0f, 1.0f, -22.0f);
        });
        Assertions.assertEquals("Blue float value must be above 0 and below 1", exception2.getMessage());
    }

    @Test
    void Test_bit_exception() {
        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour1 = new Colour(999999999);
        });
        Assertions.assertEquals("Input is larger than 24-bits", exception1.getMessage());

        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour2 = new Colour(-55);
        });
        Assertions.assertEquals("Cannot go below 0 bits", exception2.getMessage());
    }

    @Test
    void Test_random_colours1() {
        float r = 0.5f;
        float g = 1.0f;
        float b = 0.2f;
        Colour colour1 = new Colour(r, g, b);
        Assertions.assertArrayEquals(ColourConversion(r, g, b), colour1.getFullRGB());
    }

    @Test
    void Test_random_colours2() {
        float r = 0.3f;
        float g = 0.5f;
        float b = 0.6f;
        Colour colour1 = new Colour(r, g, b);
        Assertions.assertArrayEquals(ColourConversion(r, g, b), colour1.getFullRGB());
    }

    @Test
    void Test_random_colours3() {
        float r = 1.0f;
        float g = 1.0f;
        float b = 0.4f;
        Colour colour1 = new Colour(r, g, b);
        Assertions.assertArrayEquals(ColourConversion(r, g, b), colour1.getFullRGB());
    }

    @Test
    void Test_random_colours4() {
        int bits = 163424;
        Colour colour1 = new Colour(bits);
        int r = rgb_bits(bits,1);
        int g = rgb_bits(bits,9);
        int b = rgb_bits(bits,17);
        int[] is = {r, g, b};
        Assertions.assertArrayEquals(is, colour1.getFullRGB());
    }

    @Test
    void Test_random_colours5() {
        int bits = 2342;
        Colour colour1 = new Colour(bits);
        int r = rgb_bits(bits,1);
        int g = rgb_bits(bits,9);
        int b = rgb_bits(bits,17);
        int[] is = {r, g, b};
        Assertions.assertArrayEquals(is, colour1.getFullRGB());
    }

    public int[] ColourConversion(float r, float g, float b) {
        int Nr = (int) r * 255;
        int Ng = (int) g * 255;
        int Nb = (int) b * 255;
        return new int[]{Nr, Ng, Nb};
    }

    static int rgb_bits(int rgb_value, int rgb_indicator) {
        return (((1 << 8) - 1) & (rgb_value >> (rgb_indicator - 1)));
    }

}

