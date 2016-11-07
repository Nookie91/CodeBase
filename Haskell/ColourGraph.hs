-- This files contains functions related to colour graphs.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module ColourGraph
where

-- This data definition is for Graphs and their edges
data Graph = Graph Int [Edge]
data Edge = Edge Int Int

-- This data and type definition is for coloured graphs
type Colouring = [Colour]
data Colour = Blue | Green | Red
    deriving (Eq,Show)

-- This function checks that a given Graph is well formed
-- Keyword Arguments:
-- (Graph n (Edge x y:es)) - Graph that we are checking
wfg :: Graph -> Bool
wfg (Graph _ []) = True
wfg (Graph n (Edge x y:es))
    | x /= y && x <= n && y <= n = wfg (Graph n es)
    | otherwise = False

-- This function checks to this if a list of coloured nodes is correct
-- for a given Graph
-- Keyword Arguments:
-- (Graph n (Edge x y:es)) - Graph for which we are checking
-- col - List of nodes that have been assigned Colour.
well_coloured :: Graph -> Colouring -> Bool
well_coloured (Graph _ []) _ = True
well_coloured (Graph n (Edge x y:es)) col
    | col !! x /= col !! y = well_coloured (Graph n es) col
    | otherwise = False
