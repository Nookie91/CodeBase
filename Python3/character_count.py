#!/usr/bin/env python3
""" character_count contains a function for counting all instances of different
    characters in a string
"""


__author__ = "Nicholas Cook"
__email__ = "nick.james.cook@gmail.com"
__status__ = "Prototype"

def count(string):
    dict = {}
    for char in string:
        if char in dict:
            dict[char] = dict[char] + 1
        else:
            dict.update({char:1})
    return dict

def countn(input,n):
    string = input
    for x in range(n):
        s = ""
        d = count(string)
        for char in sorted(d.keys(),reverse=True):
            s = s + str(d[char]) + char
        print(s)
        string = s
    print('Final: ' + string)
