-- This file contains functions that do not belong in a category
-- Author: Nicholas James Cook
-- Email: nick.james.cook@gmail.com

module Other
where


-- Apply a function to a Maybe input. If no input is given return Nothing.
-- Keyword Arguments:
-- f - function to be applied
-- a - input to apply function to.
maybeApply :: (a -> b) -> Maybe a -> Maybe b
maybeApply _ Nothing = Nothing
maybeApply f (Just a) = Just (f a)
