package ie.tudublin;

import processing.core.PApplet;

public class Resistor {
    UI ui;
    public int value;
    public int ones;
    public int tens;
    public int hundreds;
    Colour hc;
    Colour tc;
    Colour oc;

    public Resistor(UI ui, int value) {
        this.ui = ui;
        this.value = value;
        hundreds = (value / 100);
        tens = (value - (hundreds * 100)) / 10;
        ones = value - ((hundreds * 100)  + (tens * 10));
        this.hc = ui.findColour(hundreds);
        this.tc = ui.findColour(tens);
        this.oc = ui.findColour(ones);
    }
    
    public void render(float x, float y){
        ui.pushMatrix();
        ui.translate(x, y);
        ui.stroke(0);
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        // Draw the color bars
        ui.noStroke();
        ui.fill(hc.getR(), hc.getG(), hc.getB());
        ui.rect(-40, -49, 10, 99);
        
        ui.fill(tc.getR(), tc.getG(), tc.getB());
        ui.rect(-20, -49, 10, 99);
        
        ui.fill(oc.getR(), oc.getG(), oc.getB());
        ui.rect(0, -49, 10, 99);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(30);
        ui.text(value, 200, 0);
        ui.popMatrix();
    }
}
