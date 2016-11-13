% This file contains Predicates associated with the World
% Author: Nicholas James Cook
% Email: nick.james.cook@gmail.com

:- ensure_loaded(borders).
:- ensure_loaded(cities).
:- ensure_loaded(countries).
:- ensure_loaded(rivers).

% Reduce Country from 8 to 1 arguments.
% Keyword arguments:
% C - is C a Country in countries
country(C) :- country(C,_,_,_,_,_,_,_).

% Country1 larger than Country2
% Keyword Arguments:
% Country1 - First country which is larger
% Country2 - Second country which is smaller
larger(Country1,Country2) :-
    country(Country1,_,_,_,Area1,_,_,_),
    country(Country2,_,_,_,Area2,_,_,_),
    Area1 > Area2.

% River flows through Country
% Keyword Arguments:
% River - River that flows
% Country - Country it goes through
river_country(River, Country) :-
    river(River,Countries),
    member(Country,Countries).

% Country is in Region
% Keyword Arguments:
% Country - Country in question
% Region - Belongs to Region
country_region(Country,Region) :-
    country(Country,Region,_,_,_,_,_,_).

% River flows through different Regions
% Keyword Arguments:
% River - River flows through countries in different Regions
large_river(River) :-
    river_country(River,Country1),
    river_country(River,Country2),
    country_region(Country1,Region1),
    country_region(Country2,Region2),
    \+ Region1 = Region2.
