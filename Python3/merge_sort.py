#!/usr/bin/dev/ python3
""" This Module contains the merge_sort algorithm for lists.
"""
__author__ = "Nicholas Cook"
__email__ = "nick.james.cook@gmail.com"
__status__ = "Prototype"

def merge_sort(list, base_list = True):
    """ return sorted ascending list
    Call check_element_types, check list length, if length greater
    than 1, split list and call merge_sort on two halves. Combine
    two halves returned from merge_sort and return result. 
    Should types be imcompatible the function will return None.

    Keyword arguments:
    list -- The list too be sorted.
    base_list -- original function call (default True).
    """
    
    
    try: 
        if base_list is True:    
            check_element_types(list)
        if len(list) == 1:
            return list
        elif len(list) == 0:
            return []
        elif len(list) > 1:
            slice_len = len(list) // 2 
            front_half = merge_sort(list[slice_len:], False)
            back_half = merge_sort(list[:slice_len], False)
            return combine_sorted_lists(front_half, back_half)
    except TypeError:
        print("Error: List contains mixed type comparison")
    


def combine_sorted_lists(list_one, list_two):
    """ Return the combination two sorted lists.
    Combine two sorted ascending list into one ascending
    sorted list. 
    Assumption made that arguments are sorted.

    Keyword arguments:
    list_one -- first sorted list.
    list_two -- second sorted list.
    """
    counter_one = 0
    counter_two = 0
    combined_list = []
    while counter_one<len(list_one) or counter_two<len(list_two):
        if counter_one == len(list_one):
            combined_list.append(list_two[counter_two])
            counter_two = counter_two + 1
        elif counter_two == len(list_two):
            combined_list.append(list_one[counter_one])
            counter_one = counter_one + 1
        elif list_one[counter_one] < list_two[counter_two]:
            combined_list.append(list_one[counter_one])
            counter_one = counter_one + 1
        else:
            combined_list.append(list_two[counter_two])
            counter_two = counter_two + 1
    return combined_list

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
