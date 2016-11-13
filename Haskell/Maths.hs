-- This files contains functions related to maths.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Maths
where

-- Returns the nth factorial
-- Keyword Arguments:
-- n - number we are finding the factorial of
factorial :: Int -> Int
factorial n
    | n < 0 = error "invalid input"
    | n == 0 = 1
    | otherwise = n * factorial (n-1)


-- Returns a list of Ints between two values. Inclusively.
-- Keyword Arguments:
-- minValue - the minimum value of the list
-- maxValue - the maximum value of the list
interval :: Int -> Int -> [Int]
interval minValue maxValue = [minValue..maxValue]


-- Converts a temperature from Fahrenheit to Celcius
-- Keyword Arguments
-- f - temperature to be converted.
ftoc :: Double -> Double
ftoc f = 5 / 9 * (f - 32)


-- Calculate the two quadratic roots for the given the coefficient a, b and c
-- Keyword Arguments:
-- a - 2nd order coefficient
-- b - 1st order coefficient
-- c - Constant offset
roots :: Double -> Double -> Double -> [Double]
roots a b c = [high, low]
    where
        high = (-b - sqrt (b*b - 4*a*c)) / (2*a)
        low =  (-b + sqrt (b*b - 4*a*c)) / (2*a)


-- Take a list of number and return a triple of
-- the length of the list, the sum of list and the sum of the
-- squares of the list elements
-- Keyword Arguments:
-- list - List to be summed.
sumList :: Num a => [a] -> (a,a,a)
sumList [] = (0,0,0)
sumList (x:xs) = (1 + nextLength, x + nextSum, x * x + nextSquare)
    where
        (nextLength, nextSum, nextSquare) = sumList xs


-- Apply a linear equation on a list of elements.
-- Keyword Arguments:
-- m - gradient of the line
-- c - constant offset
-- list - list of elements to apply the equation to.
linearEquation :: Num a => a -> a -> [a] -> [a]
linearEquation m c = map (\x -> m * x + c)
-- This line has been removed in place of the line above which implements
-- currying
-- linearEquation m c list = [m * x + c | x <- list]


-- Find both positive and negative roots of a number
-- Keyword Arguments:
-- x - number for which we are finding the roots
sqrtPM :: (Floating a, Ord a) => a -> [a]
sqrtPM x
    | x > 0 = let y = sqrt x in [y, -y]
    | x == 0 = [0]
    | otherwise = []


-- Find all the positive and negative square roots of a list of numbers.
-- Keyword Arguments:
-- list - list of numbers for which we want to find roots
allSqrts :: (Floating a, Ord a) => [a] -> [a]
allSqrts [] = []
allSqrts (x:xs) = sqrtPM x ++ allSqrts xs


-- Filter all negative numbers out of a list and then sqrt the
-- remaining. Using Higher Order functions
-- Keyword Arguments:
-- list - list of numbers to filter and sqrt
filterSqrtHigher :: (Floating a, Ord a) => [a] -> [a]
filterSqrtHigher = map (sqrt) . filter (>=0)


-- Filter all negative numbers out of a list and then sqrt the
-- remaining. Using no Higher Order functions
-- Keyword Arguments:
-- list - list of numbers to filter and sqrt
filterSqrtLower :: (Floating a, Ord a) => [a] -> [a]
filterSqrtLower [] = []
filterSqrtLower (x:xs)
    | x >= 0 = sqrt x : filterSqrtLower xs
    | otherwise = filterSqrtLower xs
