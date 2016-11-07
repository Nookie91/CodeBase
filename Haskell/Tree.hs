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
