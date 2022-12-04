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

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }
}

