-- This files contains functions related to prime numbers.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Prime
where

-- This function returns a Boolean value depending on
-- whether n is a prime number.
-- Keyword Arguments:
-- n - the number that we are determining if prime
prime :: Int -> Bool
prime n = fact n [2..n-1]
    where
        fact :: Int -> [Int] -> Bool
        fact _ [] = True
        fact m (x:xs)
            | m `mod` x == 0 = False
            | otherwise = fact m xs

-- Return a list of the first n Primes
-- Keyword Arguments:
-- n - The length of the list of Primes to be returned
nPrimes :: Int -> [Integer]
nPrimes n = take n $ filter isPrime [2..]
  where
    isPrime x = all (\m -> x `mod` m /= 0) [2..x-1]
