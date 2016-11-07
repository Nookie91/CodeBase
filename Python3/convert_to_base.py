#!/usr/bin/env python3
""" convert_to_base contains a function for converting an int to base
"""


__author__ = "Nicholas Cook"
__email__ = "nick.james.cook@gmail.com"
__status__ = "Prototype"

def convert_to_base(number,base):
    power = 0
    num = []
    while(pow(base,power) <= number):
        num.append(0)
        power = power + 1


    for x in range(power-1,-1,-1):
        num[power -1 - x] = number // pow(base,x)
        number = number % pow(base,x)

    print(num)
