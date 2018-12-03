package geometri;

import java.awt.*;
import java.lang.Math;

public class Square extends Rectangle{
	/**
	 * Create a square of color c with side length side at position (x,y) where (x,y) are the coordinates of
	 * the upper left corner of the square.
	 * 
	 * @param x - The x-coordinate of the upper left corner of the square.
	 * @param y - The y-coordinate of the upper left corner of the square.
	 * @param side - The length of the side of the square.
	 * @param c - The color of the square.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative. 
	 */
	public Square(int x, int y, int side, Color c) throws IllegalPositionException{
		super(x,y,side,side,c);
	 }
	 
	/**
	 * Create a square of color c with side length side at position specified by a GeometricalForm object f. 
	 * 
	 * @param f - A GeometricalForm object specifying the position of the square.
	 * @param side - The length of the side of the square.
	 * @param c - The color of the square.
	 */
	public Square(GeometricalForm f, int side, Color c){
		super(f,side,side,c);
	 }
}
