/**
 * The Colour Class
 * This class indicates the red, green and blue values of a colour
 */
public class Colour {
    private final int red;
    private final int green;
    private final int blue;

    /**
     * Constructor instantiating the red, green and blue float values
     * which signify the intensity of each colour
     * @param r float value which ranges from 0-1, describes the intensity of red colour
     * @param g float value which ranges from 0-1, describes the intensity of green colour
     * @param b float value which ranges from 0-1, describes the intensity of blue colour
     * @throws IllegalArgumentException If number of colours range above or below the range of 0-1
     */
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

    /**
     * Constructor instantiating the red, green a blue colour values with utilising a 24-bit number
     * Bits corresponding to each colour:
     *      16-23 = GREEN
     *      8-15 = BLUE
     *      0-7 = RED
     * @param bits 24-bit integer number which represents RGB colour
     * @throws IllegalArgumentException if it's not a 24-bit integer number
     */
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

    /**
     * Method for extracting specific bits from a value
     * @param rgb_value rgb value in bits
     * @param rgb_indicator indicates which bits to "extract", this decides whether you're taking the red, green or blue value
     * @return returns the red, green or blue value
     */
    static int rgb_bits(int rgb_value, int rgb_indicator)
    {
        return (((1 << 8) - 1) & (rgb_value >> (rgb_indicator - 1)));
    }


    public float getRed() {
        return this.red;
    }


    public float getGreen() {
        return this.green;
    }


    public float getBlue() {
        return this.blue;
    }

    public int[] getRGB() {
        return new int[]{this.red, this.green, this.blue};
    }
}

