package org.example;


public class Colour {


    private float red;
    private float green;
    private float blue;

    public Colour(float r, float g, float b) throws IllegalArgumentException {
        if (r<0 || r>1) {
            throw new IllegalArgumentException("Red float value must be above 0 and below 1");
        }
        else if (g<0 || g>1) {
            throw new IllegalArgumentException("Green float value must be above 0 and below 1");
        }
        else if (b<0 || b>1) {
            throw new IllegalArgumentException("Blue float value must be above 0 and below 1");
        }
        else {
            this.red = (int) r * 255;
            this.green = (int) g * 255;
            this.blue = (int) b * 255;
        }
    }

    public Colour(int bits) throws  IllegalArgumentException{
        if (bits > 16777215){
            throw new IllegalArgumentException("Input is larger than 24-bits");
        }
        else if (bits < 0) {
            throw new IllegalArgumentException("Cannot go below 0 bits");
        }
        else
            red = rgb_bits(bits,1);
            green = rgb_bits(bits,9);
            blue = rgb_bits(bits,17);



    }
    static int rgb_bits(int rgb_value, int rgb_indicator)
    {
        return (((1 << 8) - 1) & (rgb_value >> (rgb_indicator - 1)));
    }


    public float getRed() {
        return red;
    }


    public float getGreen() {
        return green;
    }


    public float getBlue() {
        return blue;
    }


}

