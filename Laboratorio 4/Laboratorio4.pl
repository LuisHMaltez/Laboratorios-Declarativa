%Si el número tiene un solo dígito (es menor a 10), 
%La lista simplemente contiene ese dígito.
almacenar(N, [N]) :- 
    N < 10.

%Para números de dos o más dígitos.
almacenar(N, [H|T]) :- 
    N >= 10,
    H is N mod 10,
    N1 is N // 10,
    almacenar(N1, T).
