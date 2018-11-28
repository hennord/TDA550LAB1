package geometri;
import java.awt.*;
import java.lang.Math;

public class Circle extends CGeometricalFrom{
	final private int diameter;
	
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
		if(x<0 || y<0) throw new IllegalPositionException();
		 this.x = x;
		 this.y = y;
		 this.diameter = diameter;
		 this.c = c; 
	}
	
	/**
	 * Create a circle of color c and diameter diameter at a position specified by the GeometricalForm object f.
	 * 
	 * @param f - A GeometricalForm object specifying the position of the circle.
	 * @param diameter - The diameter of the circle.
	 * @param c - The color of the circle.
	 */
	public Circle(GeometricalForm f, int diameter, Color c){
		this.x = f.getX();
		this.y = f.getY();
		this.diameter = diameter;
		this.c = c;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(this.c);
		g.fillOval(x,y,diameter,diameter);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getArea() {
		return (int) (Math.pow(diameter/2,2)*Math.PI);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHeight() {
		return diameter;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		return (int) (diameter*Math.PI);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return diameter;
	}
}
