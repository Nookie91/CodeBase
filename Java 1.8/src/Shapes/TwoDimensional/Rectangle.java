package Shapes.TwoDimensional;
import Mathematics.Rotation;
/**
 * author: Nicholas James Cook
 * package Shapes.TwoDimensional;
 * class: Rectangle
 * description: 
 *
 *
 */

public class Rectangle extends TwoDimensionalShape 
{
    private double length;
    private double width;
    
    public Rectangle()
    {
        super();
        this.length = 0.0;
        this.width = 0.0;
    }
    
    public Rectangle(double length, double width)
    {
        super();
        this.length = length;
        this.width = width;
    }
    
    public Rectangle(double rotation, double length, double width)
    {
        super(rotation);
        this.length = length;
        this.width = width;
    }
    
    public Rectangle(double xCoordinate, double yCoordinate, double length, double width)
    {
        super(xCoordinate, yCoordinate);
        this.length = length;
        this.width = width;
    }

    public Rectangle(double xCoordinate, double yCoordinate, double rotation, double length, double width)
    {
        super(xCoordinate, yCoordinate, rotation);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double getArea()
    {
        return length * width;
    }
    
    @Override
    public double getPerimeterLength()
    {
        return 2 * length + 2 * width;
    }
    
    @Override
    public boolean isWithin(double xCoordinate, double yCoordinate)
    {
        double x,y;
        x = Rotation.rotateX(xCoordinate - this.getXCoordinate(),
                yCoordinate - this.getYCoordinate(),
                this.getRotation());
        y = Rotation.rotateY(xCoordinate - this.getXCoordinate(),
                yCoordinate - this.getYCoordinate(),
                this.getRotation());
        
        
        return ((x >= (-length/2)) &&
                (x <= (length/2)) &&
                (y >= (-width/2)) &&
                (y <= (width/2)));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Rectangle square1 = new Rectangle(0,2.0,2.0);
        System.out.println(square1.isWithin(1.0, 1.0));
        System.out.println(square1.isWithin(2.0, 1.0));
        // TODO code application logic here
        
        square1 = new Rectangle(Math.PI/4,2.0,2.0);
        System.out.println(square1.isWithin(1.0, 1.0));
        System.out.println(square1.isWithin(0.0, 1.0));
        
        square1 = new Rectangle(1.0,1.0,0,2.0,2.0);
        System.out.println(square1.isWithin(-1.0, 1.0));
        System.out.println(square1.isWithin(2.0, 1.0));
        
        square1 = new Rectangle(1.0,1.0,Math.PI/4,2.0,2.0);
        System.out.println(square1.isWithin(1.0, 1.0));
        System.out.println(square1.isWithin(3.0, 1.0));
    }

}
