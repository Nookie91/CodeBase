/* Command Line interface for simple change calculation.
*/

/*
author: Nicholas Cook
email: nick.james.cook@gmail.com
*/

//Libraries needed by the program.
#include <stdio.h>
#include <stdio.h>

//Main Function.
void
main(int argc, char **argv)
{
    int change;
    // Ask for cents input.
    printf("Enter the amount in cents:\n");
    fflush(stdout);
    scanf("%d",&change);

    // Check bounds are valid.
    if (change>=100 || change <0)
    {
        printf("Change is not between 0 and 99 cents \n");
    }
    else if (change==0){
        printf("No change required \n");
    }
    else
    {
        // Determine change denominations and print.
        printf("The coins required to make %d cents are:\n",change);
        if (change/50 >= 1)
        {
            printf("50, ");
            change = change -50;
        }
        if (change/20 >= 1)
        {
            printf("20, ");
            change = change -20;
        }
        if (change/20 >= 1)
        {
            printf("20, ");
            change = change -20;
        }
        if (change/10 >= 1)
        {
            printf("10, ");
            change = change -10;
        }
        if (change/5 >= 1)
        {
            printf("5, ");
            change = change -5;
        }
        if (change/2 >= 1)
        {
            printf("2, ");
            change = change -2;
        }
        if (change/2 >= 1)
        {
            printf("2, ");
            change = change -2;
        }
        if (change == 1)
        {
            printf("1, ");
        }
        // Remove final comma
        printf("\b\b  \n");
    }
}
