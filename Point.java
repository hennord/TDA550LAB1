package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends GeometricalAbstractForm{
	
	/**
	 * Create a point of color c at position (x,y).
	 * 
	 * @param x - The x-coordinate of the point.
	 * @param y - The y-coordinate of the point.
	 * @param c - The color of the point.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative.
	 */
	 public Point(int x, int y, Color c) throws IllegalPositionException{
		 super(x,y,1,1,c);
		 if(x<0 || y<0) throw new IllegalPositionException();
		 this.area = 0;
		 this.perimeter = 0;
	 }
	 
	 /**
	  * Create a point of color c at a position specified by the GeometricalForm object f.
	  * 
	  * @param f - A GeometricalForm object specifying the location of the point.
	  * @param c - The color of the point.
	  */
	 public Point(GeometricalForm f, Color c){
		 super(f,1,1,c);
	 }
	
	 /**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(),getY(),1,1);
	}
}
