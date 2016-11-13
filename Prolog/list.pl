% This file contains Predicates associated with the Lists
% Author: Nicholas James Cook
% Email: nick.james.cook@gmail.com

% Is the list made up of purely Elt. Or is it an empty list.
list_of(_,[]).
list_of(Elt, [Elt|Xs]) :-
    list_of(Elt,Xs).

% Are all elements of the list the same. Empty and single element
% lists are also true.
all_same(List) :- list_of(_,List).

% Does the element E2 follow immediately after E1 in list.
adjacent1(E1,E2,List) :- append(_,[E1,E2|_],List).

% Does the element E2 follow immediately after E1 in list.
adjacent2(E1,E2,[E1,E2|_]).
adjacent2(E1,E2,[_|Tail]) :- adjacent2(E1,E2,Tail).

% Does the element E1 appear before E2 in a list
before(E1,E2,[E1|Tail]) :- member(E2,Tail).
before(E1,E2,[_|Tail]) :- before(E1,E2,Tail).

% Sum all the elements of a list.
sumlist0([], 0).
sumlist0([N|Ns], Sum) :-
    sumlist0(Ns, Sum0),
    Sum is N + Sum0.

% Sum all the elements in a list. Tail Recursive.
sumlist1(List,Sum) :- sumlist2(List,0,Sum).

sumlist2([],Sum,Sum).
sumlist2([N|Ns],Sum1,Sum) :-
    Sum2 is Sum1 + N,
    sumlist2(Ns,Sum2,Sum).
