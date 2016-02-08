/* Take two numbers, a base and a power, and print the Exponentiation.
*/

/*
author: Nicholas Cook
email: nick.james.cook@gmail.com
*/

//Libraries needed by the program.
#include <stdio.h>

// int_pow function prototype declaration
int 
int_pow(int base, int power);


// Main Function
void
main(int argc, char **argv)
{
    int base; 
    int power;

    printf("Input the base number and then a positive power\n");
    fflush(stdout);

    scanf("%d%d", &base, &power);
    if (power >= 0)
    {
        printf("%d to the power of %d = %d\n", base, 
                                               power, 
                                               int_power(base, power)
                                               );
    }
    else
    {
        printf("Error: Negative power entered.\n");
    }
    
}


/* int_pow function definition
Recursively call int_pow to calculate the exponentiation. 
Return the result of base times based raised to the power minus one.

Keyword arguments:
base -- base value.
power -- exponent to raise base to.
*/
int
int_power(int base, int power)
{
    int product = 1;

    if (power == 0)
    {
        return product;
    } 
    else 
    {
        return (base * int_power(base, power-1));
    }
}
    
    