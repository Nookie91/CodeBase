/* Command Line interface for simple unit conversions.
*/

/*
author: Nicholas Cook
email: nick.james.cook@gmail.com
*/

//Libraries needed by the program.
#include <stdio.h>

// Function Prototype declarations
void
FtoC(void);

void
CtoF(void);

void
MtoK(void);

void
KtoM(void);

void
PtoG(void);

void
GtoP(void);



// Main Function
void
main(int argc, char **argv)
{
    char type;
    // Information displayed to user.
    printf("Enter type of conversion, C, F, K, M, G, P (case sensitive)\n");
    fflush(stdout);
    
    // Call the relevant function to preform conversion requested.
    scanf("%c",&type);
    switch(type)
    {
        case 'C':
            FtoC();
            break;

        case 'F':
            CtoF();
            break;  

        case 'K':
            MtoK();
            break;

        case 'M':
            KtoM();
            break;

        case 'G':
            PtoG();
            break;

        case 'P':
            GtoP();
            break;

        default:
            break;
    }
}

// Converts Fahrenhiet to Celsius.
void
FtoC(void)
{
    float fahr, celc;
    
    printf("Please enter temperature in Fahrenhiet \n");
    fflush(stdout);
    scanf("%f",&fahr);
    
    celc = 5.0/9.0 * (fahr-32.0);
    printf("The temperature in Degrees Celcius is %f \n" ,celc);
}

// Converts Celsius to Fahrenhiet.
void
CtoF(void)
{
    float fahr, celc;
    
    printf("Please enter temperature in Celcius \n");
    fflush(stdout);
    scanf("%f",&celc);
    
    fahr = 9.0/5.0*celc + 32.0;
    printf("The temperature in Degrees Fahrenhiet is %f \n" ,celc);
}

// Converts Miles to Kilometers.
void
MtoK(void)
{
    float miles, kilometers;
    
    printf("Please enter distance in Miles \n");
    fflush(stdout);
    scanf("%f",&miles);
    
    kilometers = 1.60934 * miles;
    printf("The distance in Kilometers is %f \n" ,kilometers);
}

// Converts Kilometers to Miles.
void
KtoM(void)
{
    float miles, kilometers;
    
    printf("Please enter distance in Kilometers \n");
    fflush(stdout);
    scanf("%f",&kilometers);
    
    miles = kilometers / 1.60934;
    printf("The distance in Miles is %f \n" ,miles);
}

// Converts Pounds to Kilograms.
void
PtoG(void)
{
    float pounds, kilograms;
    
    printf("Please enter weight in Pounds \n");
    fflush(stdout);
    scanf("%f",&pounds);
    
    kilograms = pounds / 2.20462;
    printf("The weight in Kilograms is %f \n" ,kilograms);
}

// Converts Kilograms to Pounds.
void
GtoP(void)
{
    float pounds, kilograms;
    
    printf("Please enter weight in Kilograms \n");
    fflush(stdout);
    scanf("%f",&kilograms);
    
    pounds = 2.20462 * kilograms;
    printf("The weight in Kilograms is %f \n" ,pounds);
}
