package Shapes.TwoDimensional;

import Shapes.*;

/**
 * author: Nicholas James Cook
 * package Shapes.TwoDimensional;
 * class: TwoDimensionalShape
 * description: 
 *
 *
 */

public abstract class TwoDimensionalShape extends Shape
{
    private double xCoordinate;
    private double yCoordinate;
    
    private double rotation;
    
    public TwoDimensionalShape()
    {
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
        this.rotation = 0.0;
    }
    
    public TwoDimensionalShape(double xCoordinate, double yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.rotation = 0;
    }
    
    public TwoDimensionalShape(double xCoordinate, double yCoordinate, double rotation)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.rotation = rotation;
    }
    
    public TwoDimensionalShape(double rotation)
    {
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
        this.rotation = rotation;
    }
    
    public double getXCoordinate()
    {
        return xCoordinate;
    }
    
    public double getYCoordinate()
    {
        return yCoordinate;
    }
    
    public double getRotation()
    {
        return rotation;
    }
    
    public abstract double getPerimeterLength();
    
    public abstract double getArea();

    public abstract boolean isWithin(double xCoordinate, double yCoordinate);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
