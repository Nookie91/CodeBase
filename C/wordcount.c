/* Counts number of characters, words and lines.
User can select an individual type to count by entering either c, w or
l as an option. They then enter the selection of text to be read. The 
program will count all three before printing the requested output to 
stdio. 
*/

/*
author: Nicholas Cook
email: nick.james.cook@gmail.com
*/

//Libraries needed by the program.
#include    <stdio.h>
#include    <ctype.h>
#include    <string.h>
#include    <stdlib.h>

// Constants that may be predefined.
#ifndef TRUE
#define TRUE    1
#endif

#ifndef FALSE
#define FALSE   0
#endif

#ifndef bool
#define bool    int
#endif

// counter_types is used to differentiate between option inputs. 
enum counter_types
{
    CHARACTER,
    WORD,
    LINE,
    ALL
};

// Main Function
void
main(int argc, char **argv)
{
    // Variable Initialisation.
    int characters = 0;
    int words = 0;
    int lines = 0;

    bool is_current_char_in_word = FALSE;
    bool is_next_char_in_word = FALSE;

    int input_char;
    int option = '0';

    enum counter_types counter_type = ALL;

    // Option handling.
    while ((option = getopt(argc, argv, "cwl")) != EOF) 
    {
        switch (option) 
        {
            case 'c':
                counter_type = CHARACTER;
                break;

            case 'w':
                counter_type = WORD;
                break;

            case 'l':
                counter_type = LINE;
                break;

            default:
                break;
        }
    }
    
    // Counting Loop.
    while ((input_char = getchar()) != EOF) 
    {
        characters ++;

        // Is input_char an alphanumeric. Used for determining 
        // if current character is in a new word.
        if (isalnum(input_char)) 
        {
            is_next_char_in_word = TRUE;
        } 
        else 
        {
            is_next_char_in_word = FALSE;
        }

        if (!is_current_char_in_word && is_next_char_in_word) 
        {
            words ++;
        }
        is_current_char_in_word = is_next_char_in_word;

        if (input_char == '\n') 
        {
            lines ++;
        }
    }

    // Program Output.
    switch (counter_type)
    {
        case CHARACTER:
            printf("Number of characters = %6d\n", characters);
            break;

        case WORD:
            printf("Number of words = %6d\n", words);
            break;

        case LINE:
            printf("Number of lines = %6d\n", lines);
            break;

        case ALL:
        default:
            printf("Number of characters = %6d\n", characters);
            printf("Number of words = %6d\n", words);
            printf("Number of lines = %6d\n", lines);
            break;
    }
}
// Program End.
