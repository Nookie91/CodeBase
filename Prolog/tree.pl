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

% A tree
tree(empty).
tree(node(Left,_,Right)) :-
    tree(Left),
    tree(Right).

% Convert a tree into a List maintaining the trees order. Left-to-Right.
tree_list0(empty,[]).
tree_list0(node(Left,N,Right),List) :-
    append(L,[N,R],List),
    tree_list0(Left,L),
    tree_list0(Right,R).

% Convert a tree into a List maintaining the trees order. Left-to-Right.
% Tail recursive.
tree_list1(Tree,List) :- tree_list2(Tree,[],List).

tree_list2(empty,List,List).
tree_list2(node(Left,Val,Right),List1,List):-
    tree_list2(Left,List2,List),
    List2 is [Val|List3],
    tree_list2(Right,List1,List3).

list_tree([],empty).
list_tree(List,node(Left,Val,Right)) :-
    length(List,Len),
    Len2 is Len // 2,
    length(Front,Len2),
    append(Front,[Val|Back],List),
    list_tree(Front,Left),
    list_tree(Back,Right).
