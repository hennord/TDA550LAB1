
package geometri;

import java.awt.*;

public class Rectangle extends GeometricalAbstractForm{
	
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
		 super(x,y,width,height,c);
		 if(x<0 || y<0) throw new IllegalPositionException();
		 this.area = width * height;
		 this.perimeter = 2*width + 2*height;
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
		 super(f,width,height,c);
		 this.area = width * height;
		 this.perimeter = 2*width + 2*height;
		 
	 }
	
	 /**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(),getY(),getWidth(),getHeight());
	}
}
