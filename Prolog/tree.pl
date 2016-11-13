% This file contains Predicates associated with the Trees
% Author: Nicholas James Cook
% Email: nick.james.cook@gmail.com

% Find N in a Tree. If N is less than the current Val search the
% Left Branch, N equals Val, you have found it. N greater than Val
% search the right branch.
intset(N,tree(_,N,_)).
intset(N,tree(Left,Val,_)) :- N < Val, intset(N,Left).
intset(N,tree(_,Val,Right)) :- N > Val, intset(N,Right).


% If N isn't already a member of the tree insert N into the tree. 
intset(N,tree(Left,N,Right),tree(Left,N,Right)).
intset(N,empty,tree(empty,N,empty)).
intset(N,tree(Left1,Val,Right),tree(Left2,Val,Right)) :-
    N < Val,
    intset(N,Left1,Left2).
intset(N,tree(Left,Val,Right1),tree(Left,Val,Right2)) :-
    N > Val,
    intset(N,Right1,Right2).
