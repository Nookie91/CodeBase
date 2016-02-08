#!/usr/bin/dev python3


def bubble_sort(list):
    try: 
        check_element_types(list)
        has_switched = True
        while has_switched is True:
            has_switched = False
            for x in range(len(list)-1):
                if list[x] > list[x+1]:
                    temp = list[x+1]
                    list[x+1] = list[x]
                    list[x] = temp
                    has_switched = True
        return list
    except TypeError:
        print("Error: List contains mixed type comparison")

def check_element_types(list):
    """ check that all elements of the list are valid for comparison
    Throws an error if the list has different type. 
    Note: float and int are valid comparisons.
    
    Keyword argument:
    list -- elements to be checked.
    """
    for x in range(len(list)):
        if ((type(list[0]) != type(list[x])) and not
           ((type(list[0])==int and type(list[x])==float) or
            (type(list[0])==float and type(list[x])==int))):
            raise TypeError