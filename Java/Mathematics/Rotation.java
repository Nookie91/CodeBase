package Mathematics;

/**
 * author: Nicholas James Cook
 * package Mathematics;
 * class: Rotation
 */

/* This package contains Rotation Classes
It contains a basic 2D rotation with two separate function calls for 
calculating the new value of x and y. 
Also 2 move complex classes to handle 2D and 3D rotation with arrays.
*/
public class Rotation_Basic
{
    /* Return the new value of x under a rotation 
    @param {double} x - X value to be rotated.
    @param {double} y - Y value to be rotated.
    @param {double} rotation - value to rotate X and Y.
    */
    public static double rotateX(double x, double y, double rotation)
    {
        return x * Math.cos(rotation) - y * Math.sin(rotation);
    }
    
    /* Return the new value of y under a rotation 
    @param {double} x - X value to be rotated.
    @param {double} y - Y value to be rotated.
    @param {double} rotation - value to rotate X and Y.
    */
    public static double rotateY(double x, double y, double rotation)
    {
        return x * Math.sin(rotation) + y * Math.cos(rotation);
    }
}
