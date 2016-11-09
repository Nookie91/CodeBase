-- This files contains functions related to monads.
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Monads
where

-- monad ops for MaybeOK
data MaybeOK t = OK t
    | Error String

instance Monad MaybeOK
    where
        return x = OK x
        (OK x) >>= f = f x
        (Error m) >>= _ = Error m




maybe_head :: [a] -> MaybeOK a
maybe_head [] = Error "head of empty list"
maybe_head (x:_) = OK x

maybe_sqrt :: Int -> MaybeOK Double
maybe_sqrt x =
    if x >= 0 then
        OK (sqrt (fromIntegral x))
    else
        Error "sqrt of negative number"

-- definition not using monads
maybe_sqrt_of_head_1 :: [Int] -> MaybeOK Double
maybe_sqrt_of_head_1 l =
    let mh = maybe_head l in
        case mh of
            Error msg -> Error msg
            OK h -> maybe_sqrt h
-- simpler definition using monads
maybe_sqrt_of_head_2 :: [Int] -> MaybeOK Double
maybe_sqrt_of_head_2 l = maybe_head l >>= maybe_sqrt

maybe_tail :: [a] -> MaybeOK [a]
maybe_tail [] = Error "tail of empty list"
maybe_tail (_:xs) = OK xs

maybe_drop :: Int -> [a] -> MaybeOK [a]
maybe_drop _ [] = Error "n greater than list length"
maybe_drop n list
    | n == 1 = maybe_tail list
    | otherwise = maybe_drop (n-1) list
