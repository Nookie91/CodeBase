/**
*/
/**
 * author: Nicholas James Cook
 * package Arrays.Search;
 */

public class Factors
{
    // Main Function.
    public static void main(String [] args)
    {
        int numberToFactor = Integer.parseInt(args[0]);
        System.out.print("1");
        
        for(int i = 2; i <= numberToFactor; i++)
        {
            if((numberToFactor % i) == 0)
            {
                System.out.print(" " + i);
            }
        }
        System.out.print("\n"); 
    }
}
