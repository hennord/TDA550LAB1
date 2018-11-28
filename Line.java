package geometri;

import java.awt.*;
import java.lang.Math;

public class Line extends CGeometricalFrom {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	/**
	 * Create a line of color c with start position (x1,y1) and end position (x2,y2).
	 * 
	 * @param x1 - The x-coordinate of the start point of the line.
	 * @param y1 - The y-coordinate of the start point of the line.
	 * @param x2 - The x-coordinate of the end point of the line.
	 * @param y2 - The y-coordinate of the end point of the line.
	 * @param c - The color of the line.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative. 
	 */
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		if(x<0 || y<0) throw new IllegalPositionException();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.x = Math.min(x1, x2);
		this.y = Math.min(y1, y2);
		this.c = c;
	}
	
	/**
	 * Create a line of color c with start position specified by a GeometricalForm object f1 and end position
	 * specified by a GeometricalForm object f2. 
	 * 
	 * @param f1 - A GeometricalForm object specifying the start point of the line.
	 * @param f2 - A GeometricalForm object specifying the end point of the line.
	 * @param c - The color of the line.
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c){
		this.x1 = f1.getX();
		this.x2 = f2.getX();
		this.y1 = f1.getY();
		this.y2 = f2.getY();
		this.x = Math.min(f1.getX(), f2.getX());
		this.y = Math.min(f1.getY(), f2.getY());
		this.c = c;

		//this(f1.getX(),f1.getY(),f2.getX(),f2.getY(), c);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(this.c);
		g.drawLine(x1,y1,x2,y2);
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
		return Math.abs(y1-y2) ;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		return (int) (2*Math.sqrt(Math.pow(getHeight(),2)+Math.pow(getWidth(), 2)));
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return Math.abs(x1-x2);
	}
	
	 @Override
	 public void place(int x, int y) throws IllegalPositionException{
	    	if(x<0 || y<0) throw new IllegalPositionException();
	    	int dx = this.x - x;
	    	int dy = this.y - y;
	    	move(dx, dy);
	    	x1 -= dx;
	    	y1 -= dy;
	    	x2 -= dx;
	    	y2 -= dy;
	    }

}
