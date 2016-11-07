-- This file contains a function for determining the most frequent in
-- letter in a list of strings
-- Author: Nicholas Cook
-- Email: nick.james.cook@gmail.com
module MostFrequent
where

import Data.List

-- Takes a list of strings and returns the most frequent letter
-- that occurs in that list.
-- Keyword Arguments:
-- list -- a list of Strings
most_frequent :: [String] -> Char
most_frequent list = mf (sort (concat list))
    where
        mf :: [Char] -> Char
        mf letters = mf' ' ' 0 ' ' 0 letters
        mf' :: Char -> Int -> Char -> Int -> [Char] -> Char
        mf' x _ _ _ [] = x
        mf' x n y m (z:zs)
            | x == z = mf' x (n+1) y (m+1) zs
            | y == z && (m+1) > n = mf' z (m+1) z (m+1) zs
            | y == z = mf' x n y (m+1) zs
            | otherwise = mf' x n z 1 zs
