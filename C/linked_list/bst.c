#include <stdio.h>
#include <string.h>
#define NAME_BUFFER 80

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


typedef struct person
{
    char last_name[NAME_BUFFER];  
    char first_name[NAME_BUFFER];
    char middle_name[NAME_BUFFER];
    unsigned int age;

    children = 0;
    person_t link_ascending = NULL;
    person_t link_descending = NULL;
} person_t;

person_t*
search(char first_name[], char last_name[], person_t list);
int
compare_names(char first_name[], char middle_name[], char last_name[], person_t person);

bool
add_person(person_t new_person, person_t list);

bool
remove_person(char first_name[], char last_name[], person_t list);

void
rebalance_tree(person_t list);

person_t*
search(char first_name[], char last_name[], person_t *list)
{
    int direction;
    person_t next_person = list 
    do
    {
        direction = compare_names(first_name, middle_name, last_name, next_person);


        if (direction == -1)
        {
            if(next_person->link_descending != NULL)
            {
                next_person = next_person->link_descending;
            }
            else
            {
                return NULL;
            }
            
        }
        else if (direction == 1)
        {
            if(next_person->link_ascending != NULL)
            {
                next_person = next_person->link_ascending;
            }
            else
            {
                return NULL;
            }
        }
        else
        {
            return next_person;      
        }
    }
    while(next_person->link_ascending != NULL &&
          next_person->link_descending != NULL)
}

bool 
add_person(person_t new_person, person_t list)
{

}

int
compare_names(char first_name[], char middle_name[], char last_name[], person_t person)
{
    if (strcmp(person->last_name,last_name) < 1)
    {
        return -1;
    }
    else if (strcmp(person->last_name,last_name) > 1)
    {
        return 1;
    }
    else if (strcmp(person->first_name,first_name) < 1)
    {
        return -1;
    }
    else if (strcmp(person->first_name,first_name) > 1)
    {
        return 1;
    }
    else if (strcmp(person->middle_name,middle_name) < 1)
    {
        return -1;
    }
    else if (strcmp(person->middle_name,middle_name) > 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }

}

