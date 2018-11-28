package geometri;

import java.awt.*;

public class Rectangle extends CGeometricalFrom{
	private int width;
	private int height;
	
	/**
	 * Create a rectangle of color c with width width and height height at position (x,y) where (x,y) are the coordinates of
	 * the upper left corner of the rectangle.
	 * 
	 * @param x - The x-coordinate of the upper left corner of the rectangle.
	 * @param y - The y-coordinate of the upper left corner of the rectangle.
	 * @param width - The width of the rectangle.
	 * @param height - The height of the rectangle.
	 * @param c - The color of the rectangle.
	 * @throws <tt>IllegalPositionException</tt> - If any coordinate is negative. 
	 */
	 public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		 System.out.println("x ="+x); System.out.println("y ="+y);
		 if(x<0 || y<0) throw new IllegalPositionException();
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 this.c = c;
	 }
	 
	 /**
	  * Create a rectangle of color c with width width and height height at a position specified by a GeometricalForm
	  * object.
	  * 
	  * @param f - A GeometricalForm object specifying the position of the rectangle.
	  * @param width - The width of the rectangle.
	  * @param height - The height of the rectangle.
	  * @param c - The color of the rectangle.
	  */
	 public Rectangle(GeometricalForm f, int width, int height, Color c){
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
		g.fillRect(x,y,width,height);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getArea() {
		return width*height;
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
		return 2*width+2*height;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getWidth() {
		return width;
	}
	

}
