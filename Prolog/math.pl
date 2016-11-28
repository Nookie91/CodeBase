% This file contains Predicates associated with maths
% Author: Nicholas James Cook
% Email: nick.james.cook@gmail.com


% times(W,X,Y,Z) holds when W*X + Y = Z and either
% 0 <= Y < W or W < Y <= 0. This should work when any 3 arguments are
% bound to integers, or when Z and one of W and X are bound to integers.
% In these modes, this predicate should be deterministic.
times(W,X,Y,Z) :-
    (integer(Z)
    ->  (integer(W)
        ->  X is Z div W
        ,   Y is Z mod W
        ;   (integer(X)
            ->  W is Z div X
            ,   Y is Z rem X
            ;   throw(error(instantiation_error, context(times/4,_)))
            )
        )
    ;   (integer(W), integer(X), integer(Y)
        ->  Z is W * X + Y
        ;   throw(error(instantiation_error, context(times/4,_)))
        )
    ).
