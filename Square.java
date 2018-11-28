package geometri;

import java.awt.*;
import java.lang.Math;

public class Square extends CGeometricalFrom{
	private int side;
	
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
		if(x<0 || y<0) throw new IllegalPositionException();
		 this.x = x;
		 this.y = y;
		 this.side = side;
		 this.c = c;
	 }
	 
	/**
	 * Create a square of color c with side length side at position specified by a GeometricalForm object f. 
	 * 
	 * @param f - A GeometricalForm object specifying the position of the square.
	 * @param side - The length of the side of the square.
	 * @param c - The color of the square.
	 */
	public Square(GeometricalForm f, int side, Color c){
		 this.x = f.getX();
		 this.y = f.getY();
		 this.side = side;
		 this.c = c; 
	 }
	
	/**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(this.c);
		g.fillRect(x,y,side,side);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getArea() {
		return (int) Math.pow(side,2);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHeight() {
		return side;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		return 4*side;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return side;
	}
}

