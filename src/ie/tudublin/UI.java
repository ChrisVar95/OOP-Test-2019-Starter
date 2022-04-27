package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{	
	ArrayList<Colour> colours = new ArrayList<Colour>();
	ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	public void loadColours(){
		Table t = loadTable("colours.csv", "header");
		for(TableRow r:t.rows()){
			Colour colour = new Colour(r);
			colours.add(colour);
		}
	}
	public void printColours(){
		for(Colour c: colours){
			System.out.println(c);
		}
	}

	public Colour findColour(int value){
		for(Colour c: colours){
			int num = c.getValue();
			if(num == value){
				return c;
			}
		}
		return null;
	}
	public void loadResistors(){
		Table t = loadTable("resistors.csv", "header");
		for(TableRow r:t.rows()){
			Resistor resistor = new Resistor(this, r.getInt(0));
			resistors.add(resistor);
		}
	}
	public void printResistors(){
		for(Resistor r:resistors)
		{
			int i = r.value;
			int hundreds = (i / 100);
			int tens = (i - (hundreds * 100)) / 10;
			int ones = i - ((hundreds * 100)  + (tens * 10));
			print(hundreds + ",");
			print(tens + ",");
			println(ones);			
		}
	}

	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings()
	{
		size(500, 800);
		loadColours();
		loadResistors();
	}

	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(200);
		stroke(255);

		for(int i = 0 ; i < resistors.size() ; i ++)
		{
			float y = map(i, 0, resistors.size(), 100, height - 100);
			resistors.get(i).render(width / 2, y);
		}
	}
}
