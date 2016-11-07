-- This files contains functions related to expressions.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Expression
where

-- The data constructor for various types of expressions
data Expression
    = Var Variable
    | Num Integer
    | Plus Expression Expression
    | Minus Expression Expression
    | Times Expression Expression
    | Div Expression Expression

-- The data constructor for the two diiferent input variables
data Variable = A | B


-- Evaluate an expression given two input Integer arguments.
-- Keyword Arguments:
-- a - First Integer input argument
-- b - Second Integer input argument
-- expr - expression to be evalutated
eval :: Integer -> Integer -> Expression -> Integer
eval a _ (Var A) = a
eval _ b (Var B) = b
eval _ _ (Num x) = x
eval a b (Plus exp1 exp2) = eval a b exp1 + eval a b exp2
eval a b (Minus exp1 exp2) = eval a b exp1 - eval a b exp2
eval a b (Times exp1 exp2) = eval a b exp1 * eval a b exp2
eval a b (Div exp1 exp2) = eval a b exp1 `div` eval a b exp2
