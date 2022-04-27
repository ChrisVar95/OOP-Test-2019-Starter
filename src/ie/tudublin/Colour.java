package ie.tudublin;

import processing.data.TableRow;

public class Colour {
    private int r;
    private int g;
    private int b;
    private int value;
    public Colour( int r, int g, int b, int value) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }

    public Colour(TableRow tr){
        this(tr.getInt("r"), tr.getInt("g"), tr.getInt("b"), tr.getInt("value"));
    }
    public String toString() {
        return this.r + ", " + this.g + ", " + this.b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
}
