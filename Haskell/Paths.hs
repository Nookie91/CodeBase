-- This files contains functions related to determing paths
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Paths
where

-- Find the number of paths that can be traversed from the bottom
-- left to top right of an n by m grid. Where you can only move right or up.
-- Keyword Arguments:
-- n - length of grid in the x direction
-- m - length of grid in the y direction
paths :: Int -> Int -> Int
paths n m
    | n == 1 && m == 1 = 1
    | m == 1 = paths (n-1) m
    | n == 1 = paths n (m-1)
    | otherwise = paths (n-1) m + paths n (m-1)
