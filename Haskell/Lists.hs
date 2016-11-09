-- This files contains functions related to lists.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Lists
where

-- This function takes a list and returns it in reverse order.
-- Keyword Arguments:
-- (x:xs) - list to be reversed
myReverse :: [a] -> [a]
myReverse [] = []
myReverse (x:xs) = myReverse xs ++ [x]


-- Return the nth element of a list.
-- If the index is out of bounds throw an error.
-- Keyword Arguments:
-- n - the index of the element to be returned
-- (x:xs) - the list of type a objects to reutnr value from.
getNthElement :: Int -> [a] -> a
getNthElement _ [] = error "Invalid Index"
getNthElement n (x:xs)
    | n == 1 = x
    | otherwise = getNthElement (n-1) xs


-- Return a Boolean based on if x exists in list
-- Keyword Argument:
-- x - element for which we are checking membership
-- (y:ys) - list we are checking if x is an element of
myElem :: Eq a => a -> [a] -> Bool
myElem _ [] = False
myElem x (y:ys)
    | x == y = True
    | otherwise = myElem x ys


-- Return the longest common prefix between two lists.
-- Keyword Arguments:
-- (x:xs) - the first list
-- (y:ys) - the second list
longestPrefix :: Eq a => [a] -> [a] -> [a]
longestPrefix [] _ = []
longestPrefix _ [] = []
longestPrefix (x:xs) (y:ys)
    | x == y = x : longestPrefix xs ys
    | otherwise = []



-- merge two sorted lists of the same type into one
-- Keyword Arguments:
-- x - first sorted list
-- y - second sorted list
mergeSorted :: Ord a => [a] -> [a] -> [a]
mergeSorted [] y = y
mergeSorted x [] = x
mergeSorted (x:xs) (y:ys)
        | x < y = x : mergeSorted xs (y:ys)
        | otherwise = y : mergeSorted (x:xs) ys


-- Sort a list of elements of type Ord a utilising the quick sort algorithm
-- Keyword Arguments:
-- (x:xs) - list to be sorted.
quickSort :: Ord a => [a] -> [a]
quickSort [] = []
quickSort (x:xs) = smallerSorted ++ [x] ++ largerSorted
    where
        smallerSorted = quickSort [a | a <- xs, a <= x]
        largerSorted = quickSort [a | a <- xs, a > x]

transpose :: [[a]] -> [[a]]
transpose [] = []
transpose (x:xs) = combine [[s] | s <- x] (transpose xs)


combine :: [[a]] -> [[a]] -> [[a]]
combine [] [] = []
combine [] (_:_) = error "invalid input"
combine (x:xs) [] = x : combine xs []
combine (x:xs) (y:ys) = (x ++ y) : combine xs ys
