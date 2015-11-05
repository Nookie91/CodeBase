package Shapes.TwoDimensional;

/**
 * author: Nicholas James Cook
 * package Shapes.TwoDimensional;
 * class: Circle
 * description: 
 *
 *
 */

public class Circle extends TwoDimensionalShape
{
    private double radius;
    
    public Circle()
    {
        super();
        this.radius = 0.0;
    }
    
    public Circle(double radius)
    {
        super();
        this.radius = radius;
    }
    
    public Circle(double xCoordinate, double yCoordinate, double radius)
    {
        super(xCoordinate, yCoordinate);
        this.radius = radius;
    }
    
    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeterLength()
    {
        return Math.PI * radius * 2;
    }
    
    @Override
    public boolean isWithin(double xCoordinate, double yCoordinate)
    {
        return ((Math.pow(xCoordinate - this.getXCoordinate(),2) +
                Math.pow(yCoordinate - this.getYCoordinate(),2)) <= Math.pow(radius,2));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Circle circ = new Circle(-1.0,0.0,3.0);
        System.out.println(circ.getArea());
        System.out.println(circ.isWithin(-3.0, 0.0));
    }

}
