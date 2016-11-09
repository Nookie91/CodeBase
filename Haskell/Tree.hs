-- This files contains functions related to trees.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Tree
where

data Tree k v = Leaf | Node k v (Tree k v) (Tree k v)
    deriving (Eq, Show)

-- Determine if two Trees have the same structure of Leafs and Nodes
-- Keywords Arguments
-- First Tree - The first tree in the comparison
-- Second Tree - The second tree in the comparison
sameShape :: Tree a b -> Tree c d -> Bool
sameShape Leaf Leaf = True
sameShape Leaf Node {} = False
sameShape Node {} Leaf = False
sameShape (Node _ _ left1 right1) (Node _ _ left2 right2)
    = sameShape left1 left2 && sameShape right1 right2


-- Sort a list by utilising a BST.
-- Keyword Arguments:
-- list - List to be sorted.
sortWithTree :: Ord a => [a] -> [a]
sortWithTree list = flattenTree (createBST list)


-- Create a new BST from a list of values
-- Keyword Arguments:
-- list - list to create BST from
createBST :: Ord a => [a] -> Tree Char a
createBST [] = Leaf
createBST (x:xs) = addBST (createBST xs) ' ' x


-- Add a new Node to an existing tree
-- Keyword Arguments:
-- Tree - Tree to add node to
-- key - key of the new node
-- value - value of the new node
addBST :: Ord a => Tree b a -> b -> a -> Tree b a
addBST Leaf x y = Node x y Leaf Leaf
addBST (Node k v left right) x y
    | y <= v = Node k v (addBST left x y) right
    | otherwise = Node k v left (addBST right x y)


-- Flatten a Tree into a List.
-- Keyword Arguments:
-- Tree - Tree to be flattened
flattenTree :: Tree b a -> [a]
flattenTree Leaf = []
flattenTree (Node _ v left right)
    = flattenTree left ++ [v] ++ flattenTree right
