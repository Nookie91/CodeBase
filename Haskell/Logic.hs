-- This file contains functions for basic logic operations on Booleans
-- Author: Nicholas Cook
-- Email: nick.james.cook@gmail.com

module Logic
where

-- This function implements the logical Xor function.
-- If x does not equal y return True
-- Keyword Arguments:
-- x - Boolean value for comparison
-- y - Boolean value for comparison
xor :: Bool -> Bool -> Bool
xor x y
    | x == y = False
    |otherwise = True


-- This function implements the logical Or function.
-- If x or y is True return True
-- Keyword Arguments:
-- x - Boolean value for comparison
-- y - Boolean value for comparison
or :: Bool -> Bool -> Bool
or x y
    | x == True or y == True = True
    |otherwise = False


-- This function implements the logical And function.
-- If x and y is True return True
-- Keyword Arguments:
-- x - Boolean value for comparison
-- y - Boolean value for comparison
and :: Bool -> Bool -> Bool
and x y
    | x == True and y == True = True
    |otherwise = False


-- This function implements the logical Not function.
-- If x is True return False
-- Keyword Arguments:
-- x - Boolean value for comparison
not :: Bool -> Bool
not x
    | x == True = False
    |otherwise = True


-- This function implements the logical Nor function.
-- If x or y is True return False
-- Keyword Arguments:
-- x - Boolean value for comparison
-- y - Boolean value for comparison
nor :: Bool -> Bool -> Bool
nor x y = not (or x y)
