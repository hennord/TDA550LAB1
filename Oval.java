package geometri;

import java.awt.*;


public class Oval extends CGeometricalFrom{
	private int width;
	private int height;
	
	/**
	 * Create an oval of color c with width width and height height at position (x,y) where (x,y) are the coordinates of
	 * the upper left corner of the smallest rectangle inscribing the circle.
	 * 
	 * @param x - The x-coordinate of the upper left corner of the smallest rectangle inscribing the oval.
	 * @param y - The y-coordinate of the upper left corner of the smallest rectangle inscribing the oval.
	 * @param width - The width of the smallest rectangle inscribing the oval.
	 * @param height - The height of the smallest rectangle inscribing the oval.
	 * @param c - The color of the oval.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative.
	 */
	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		if(x<0 || y<0) throw new IllegalPositionException();
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 this.c = c;
	}
	
	/**
	 * Create an oval of color c with width width and height height at a position specified by the GeometricalForm object f.
	 * 
	 * @param f - A GeometricalForm object specifying the location of the oval.
	 * @param width - The width of the smallest rectangle inscribing the oval.
	 * @param height - The height of the smallest rectangle inscribing the oval.
	 * @param c - The color of the oval.
	 */
	public Oval(GeometricalForm f, int width, int height, Color c){
		this.x = f.getX();
		this.y = f.getY();
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(this.c);
		g.fillOval(x,y,width,height);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getArea() {
		return (int) (width*height*Math.PI)/4;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		return (int) (Math.PI*Math.sqrt(0.5*Math.pow(width,2)+0.5*Math.pow(height,2)));
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return width;
	}
}
