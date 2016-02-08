/* This simple program reads a table of string keys and integer values 
from a file named on the command line, and then accepts queries from 
standard input. Each query is a string key. If the key exists in the 
table, the program outputs the corresponding value. If the key does not 
exist in the table, the program prints a message to this effect.

cmd inputs:
insert -- insert new entry into table.
lookup -- lookup up value by key.
remove -- remove entry with key from table.
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

// Max array size for the table storage array
#define TABLE_SIZE 10

// Function Prototype Declaration.
void 
*checked_malloc(int size);

// Typedef for structure to hold table entry.
typedef struct {
    char    *key;
    int     value;
} entry_t;

// Main Function.
void
main(int argc, char **argv)
{

    // Table initialisation.
    entry_t table[TABLE_SIZE];
    // Iteration variable.
    int next_entry;
    // Input buffers
    char key_buf[80];
    char cmd_buf[80];
    int value_buf;
    // File pointer.
    FILE *fp;

    // Check valid number of program arguments.
    if (argc != 2) {
        printf("usage: table filename\n");
        exit(1);
    }

    // Load file from filename given in program arguments.
    fp = fopen(argv[1], "r");
    if (fp == NULL) 
    {
        perror("data");
        exit(1);
    }
    // Copy data from input file and copy table values.
    next_entry = 0;
    while (fscanf(fp, "%s %d\n", key_buf, &value_buf) == 2) 
    {
        table[next_entry].key = checked_malloc(strlen(key_buf) + 1);
        strcpy(table[next_entry].key, key_buf);
        table[next_entry].value = value_buf;
        next_entry++;
    }
    // Close the file access.
    fclose(fp);

    printf("Enter Command: insert, lookup or remove.\n");
    // Main loop of function. Process cmds.
    while (scanf("%s", cmd_buf) == 1) 
    {
        
        // lookup up key: value pair.
        if (strcmp(cmd_buf, "lookup") == 0) 
        {
            int     i;
            bool    found;
            printf("Enter key to lookup.\n");
            if (scanf("%s", key_buf) != 1) 
            {
                printf("expected key to look up\n");
                exit(1);
            }

            found = FALSE;
            for (i = 0; i < next_entry; i++) 
            {
                if (strcmp(key_buf, table[i].key) == 0) {
                    printf("the value corresponding to key %s is %d\n",
                                                        table[i].key, 
                                                        table[i].value
                                                        );
                    found = TRUE;
                }
            }

            if (!found) 
            {
                printf("there is no value corresponding to key %s\n", key_buf);
            }
        } 
        // insert new key: value pair into table.
        else if (strcmp(cmd_buf, "insert") == 0) 
        {
            if (next_entry == TABLE_SIZE)
            {
                printf("table is full\n");
                continue;
            }
            printf("Enter key value pair to insert.\n");
            if (scanf("%s %d", key_buf, &value_buf) != 2) 
            {
                printf("expected key and value to insert\n");
                exit(1);
            }

            table[next_entry].key = checked_malloc(strlen(key_buf) + 1);
            strcpy(table[next_entry].key, key_buf);
            table[next_entry].value = value_buf;
            next_entry++;
        } 
        // remove key: value pair from the table.
        else if (strcmp(cmd_buf, "remove") == 0) 
        {
            int     i;
            bool    found;
            printf("Enter key to remove.\n");
            if (scanf("%s", key_buf) != 1) 
            {
                printf("expected key to remove\n");
                exit(1);
            }

            found = FALSE;
            for (i = 0; i < next_entry; i++) 
            {
                if (strcmp(key_buf, table[i].key) == 0) 
                {
                    // The space for this key was allocated by malloc.
                    free(table[i].key);
                    printf("deleted the key-value pair %s %d\n", table[i].key, 
                                                                 table[i].value
                                                                 );
                    found = TRUE;
                    /* This was not the last entry, so to avoid leaving
                    a hole in the middle of the table, move the last 
                    entry here.
                    */
                    if (i < next_entry - 1) 
                    {
                        
                        table[i].key = table[next_entry - 1].key;
                        table[i].value = table[next_entry - 1].value;
                        next_entry--;
                    }
                }
            }

            if (!found) 
            {
                printf("there was no key-value pair with key %s\n", key_buf);
            }
        }
        // unrecognized command. 
        else 
        {
            printf("unrecognized command %s\n", cmd_buf);
            continue;
        }
        printf("Enter Command: insert, lookup or remove.\n");
    }
}

/* Confirm that malloc returns a valid pointer. If not exit program.
Keyword argument:
size -- size of space required.
*/
void *
checked_malloc(int size)
{
    char    *p;

    p = malloc(size);
    if (p == NULL) 
    {
        printf("Ran out of memory\n");
        exit(1);
    }

    return p;
}
