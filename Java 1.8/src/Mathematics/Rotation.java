package Mathematics;

/**
 * author: Nicholas James Cook
 * package Mathematics;
 * class: Rotation
 * description: 
 *
 *
 */

public class Rotation 
{
    public static double rotateX(double x, double y, double rotation)
    {
        return x * Math.cos(rotation) - y * Math.sin(rotation);
    }
    
    public static double rotateY(double x, double y, double rotation)
    {
        return x * Math.sin(rotation) + y * Math.cos(rotation);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(rotateX(0.0,-Math.sqrt(2),Math.PI/4));
        System.out.println(rotateY(0.0,-Math.sqrt(2),Math.PI/4));
        // TODO code application logic here
    }

}
