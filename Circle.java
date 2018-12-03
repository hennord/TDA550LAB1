package geometri;

import java.awt.*;
import java.lang.Math;

public class Circle extends Oval{
	
	/**
	 * Create a circle of color c and diameter diameter at position (x,y) where (x,y) are the coordinates of
	 * the upper left corner of the smallest rectangle inscribing the circle.
	 * 
	 * @param x - The x-coordinate of the upper left corner of the smallest rectangle inscribing the circle.
	 * @param y - The y-coordinate of the upper left corner of the smallest rectangle inscribing the circle.
	 * @param diameter - The diameter of the circle.
	 * @param c - The color of the circle.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative.
	 */
	public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException{
		super(x,y,diameter,diameter,c);
		if(x<0 || y<0) throw new IllegalPositionException();
	}
	
	/**
	 * Create a circle of color c and diameter diameter at a position specified by the GeometricalForm object f.
	 * 
	 * @param f - A GeometricalForm object specifying the position of the circle.
	 * @param diameter - The diameter of the circle.
	 * @param c - The color of the circle.
	 */
	public Circle(GeometricalForm f, int diameter, Color c){
		super(f,diameter,diameter,c);
	}
}
