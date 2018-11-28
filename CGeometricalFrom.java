package geometri;
import java.awt.*;

public abstract class CGeometricalFrom implements GeometricalForm {
	protected int x;
	protected int y;
	protected Color c;
	
	/**
	 * {@inheritDoc}
	 */
	public int compareTo(GeometricalForm f) {
		if (this.getArea()>f.getArea()){
			return 1;
		} else if (this.getArea()<f.getArea()){
			return -1;
		} else if (this.getPerimeter()>f.getPerimeter()){
			return 1;
		} else if (this.getPerimeter()<f.getPerimeter()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * {@inheritDoc}
	 */
    public int getX(){
    	return x;
    }
    
    /**
	 * {@inheritDoc}
	 */
    public int getY(){
    	return y;
    }
  
    /**
	 * {@inheritDoc}
	 */
    public void move(int dx, int dy) throws IllegalPositionException{
    	int tempX = x-dx;
    	int tempY = y-dy;
    	if (tempX<0 || tempY<0) throw new IllegalPositionException();
    	else{
    		x = tempX;
    		y =tempY;
    	}
    }
    
    /**
	 * {@inheritDoc}
	 */
    public void place(int x, int y) throws IllegalPositionException{
    	if(x<0 || y<0) throw new IllegalPositionException();
    	this.x = x;
    	this.y = y;
    }
	
	
	 
}
