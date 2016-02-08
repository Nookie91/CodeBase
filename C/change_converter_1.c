/* Command Line interface for simple change calculation.
*/

/*
author: Nicholas Cook
email: nick.james.cook@gmail.com
*/

//Libraries needed by the program.
#include <stdio.h>

// Function Prototype declarations
int 
round_to_five(int cents);

int 
try_one_coin(int cents, int coin);

void 
print_change(int cents);


// Main Function. 
void
main(int argc, char argv)
{
    int cents;
    // Ask for cents input.
    printf("Enter amount in cents between 0 and 99: \n");
    fflush(stdout);
    scanf("%d", &cents);

    // Checks bounds on cents and call print_change.
    if (cents >= 0 && cents <= 99)
    {
        print_change(cents);    
    }
    else
    {
        printf("Error: Please enter an amount between 0 and 99\n");
    }
}

/* Print denomination combination that fits into cent total.
Call round_to_five then iterate through the denominations, if a 
denomination can be removed from the cent total, print the number and 
subtract it from cents.
*/
void
print_change(int cents){
    int coin;

    cents = round_to_five(cents);

    coin = 100;
    if (try_one_coin(cents, coin)==1){
        printf("%d, ", coin);
        cents = cents - coin;
    }

    coin = 50;
    if (try_one_coin(cents, coin)==1){
        printf("%d, ", coin);
        cents = cents - coin;
    }

    coin = 20;
    if (try_one_coin(cents, coin)==1){
        printf("%d, ", coin);
        cents = cents - coin;
    }

    coin = 20;
    if (try_one_coin(cents, coin)==1){
        printf(", %d", coin);
        cents = cents - coin;
    }

    coin = 10;
    if (try_one_coin(cents, coin)==1){
        printf("%d, ", coin);
        cents = cents - coin;
    }

    coin = 5;
    if (try_one_coin(cents, coin)==1){
        printf("%d, ", coin);
        cents = cents - coin;
    }
    // Remove final comma and print new line.
    printf("\b\b  \n");
}

// Return 1 if a coin value is smaller than cents, else return 0
int
try_one_coin(int cents, int coin){
    if (cents >= coin){
        return 1;
    }
    else{ 
        return 0;
    }
}

// Return cents rounded to nearest 5.
int
round_to_five(int cents){
    if (cents % 5 >= 3)
    {
        return cents + (5 - cents%5);
    }
    else{
        return cents - cents%5;
    }
}