package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends CGeometricalFrom{
	
	/**
	 * Create a point of color c at position (x,y).
	 * 
	 * @param x - The x-coordinate of the point.
	 * @param y - The y-coordinate of the point.
	 * @param c - The color of the point.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative.
	 */
	 public Point(int x, int y, Color c) throws IllegalPositionException{
		 if(x<0 || y<0) throw new IllegalPositionException();
		 this.x = x;
		 this.y = y;
		 this.c = c;
	 }
	 
	 /**
	  * Create a point of color c at a position specified by the GeometricalForm object f.
	  * 
	  * @param f - A GeometricalForm object specifying the location of the point.
	  * @param c - The color of the point.
	  */
	 public Point(GeometricalForm f, Color c){
		 this.x = f.getX();
		 this.y = f.getY();
		 this.c = c;
	 }
	
	 /**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(this.c);
		g.fillOval(x,y,1,1);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getArea() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHeight() {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return 1;
	}
	
}
