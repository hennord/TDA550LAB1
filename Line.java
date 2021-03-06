package geometri;

import java.awt.*;
import java.lang.Math;

public class Line extends GeometricalAbstractForm {
	private final boolean inclinedUp;

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
		super(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2),c);
		if(x1<0 || y1<0 || x2<0 || y2<0) throw new IllegalPositionException();
		if(y2<y1){
			inclinedUp = true;
		}else {
			inclinedUp = false;
		}
		this.area = 0;
		this.perimeter = (int) (2*Math.sqrt(Math.pow(getHeight(),2)+Math.pow(getWidth(), 2)));
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
		super(Math.min(f1.getX(),f2.getX()),Math.min(f1.getY(),f2.getY()),Math.abs(f1.getX()-f2.getX()),Math.abs(f1.getX()-f2.getX()),c);
		if(f2.getY()<f1.getY()) {
			inclinedUp = true;
		}else {
			inclinedUp = false;
		}
		this.area = 0;
		this.perimeter = (int) (2*Math.sqrt(Math.pow(getHeight(),2)+Math.pow(getWidth(), 2)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void fill(Graphics g) {
		g.setColor(getColor());
		if(inclinedUp ) {
			g.drawLine(getX(),getY()+getHeight(),getX()+getWidth(),getY());
		}else {
			g.drawLine(getX(),getY(),getX()+getWidth(),getY()+getHeight());
		}
	}
	
	/* @Override
	 public void place(int x, int y) throws IllegalPositionException{
	    	if(x<0 || y<0) throw new IllegalPositionException();
	    	int dx = getX() - x;
	    	int dy = getY() - y;
	    	move(dx, dy);
	    	super.place(x,y);
	    	x2 -= dx;
	    	y2 -= dy;
	    }*/
}
