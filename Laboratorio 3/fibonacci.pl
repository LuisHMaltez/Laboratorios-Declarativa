% Regla 1: Caso base (Fibonacci de 0)
fib(0, 0).

% Regla 2: Caso base (Fibonacci de 1)
fib(1, 1).

% Regla 3: Caso recursivo
fib(N, R) :-
    N > 1,
    N1 is N - 1,
    N2 is N - 2,
    fib(N1, R1),
    fib(N2, R2),
    R is R1 + R2.