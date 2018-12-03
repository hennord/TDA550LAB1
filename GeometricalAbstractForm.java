package geometri;
import java.awt.*;

public abstract class GeometricalAbstractForm implements GeometricalForm {
	/**
	 * The x coordinate of this GeometricalForm.
	 */
	private int x;
	
	/**
	 * The y coordinate of this GeometricalForm.
	 */
	private int y;
	
	/**
	 * The color of this GeometricalForm.
	 */
	final private Color c;
	final private int width;
	final private int height;
	protected int perimeter;
	protected int area;
	
	public GeometricalAbstractForm(int x, int y,int width,int height,Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.width = width;
		this.height = height;
	}
	
	public GeometricalAbstractForm(GeometricalForm f, int width, int height, Color c) {
		this(f.getX(),f.getY(), width,height,c);
	}
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
    public int getArea() {
    	return area;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getPerimeter() {
    	return perimeter;
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
    public int getWidth() {
    	return width;
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
	
    /**
     * @param f an object to compare this GeometricalForm to.
     * @return true if the compared objects are GeometricalForms with the same 
     * area,perimeter and color.
     */
    @Override
	public boolean equals(Object otherObject) {
		if(this == otherObject) {
			return true;
		}
		if(otherObject == null) {
			return false;
		}
		if(!(otherObject instanceof GeometricalForm)) {
			return false;
		}
		GeometricalForm otherForm = (GeometricalForm) otherObject;
		return this.compareTo(otherForm) == 0 && this.c.equals(otherForm.getColor());
	}
	
	/**
	 *@return a hash code value for the GeometricalForm object.
	 */
	@Override
	public int hashCode() {
		return 3*area + 5*perimeter;
	}
}