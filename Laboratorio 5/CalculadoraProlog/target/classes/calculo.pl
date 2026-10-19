% ==========================================
% REGLAS DE DERIVACIÓN
% ==========================================

% Derivada de una constante (es 0)
d(Var, Func, 0) :- atomic(Var), number(Func).

% Derivada de una variable respecto a sí misma (es 1)
d(Var, Var, 1) :- atomic(Var).

% Derivada de una constante por una variable (ej. 4*x -> 4)
d(Var, N*Var, N) :- atomic(Var), number(N).

% Derivada de una variable elevada a la N (ej. x^3 -> 3*x^2)
d(Var, Var^N, N*Var^Nm1) :- number(N), Nm1 is N-1.

% Derivada de constante por variable a la N (ej. 3*x^2 -> 6*x^1)
d(Var, K*Var^N, C*Var^Nm1) :- atomic(K), number(K), number(N), C is K*N, Nm1 is N-1.

% Derivada de un logaritmo natural (ej. log(x) -> 1/x)
d(Var, log(Var), 1/Var) :- atomic(Var).


% ==========================================
% REGLAS DE INTEGRACIÓN
% ==========================================

% Integral de una constante (ej. 5 -> 5*x)
s(Var, K, K*Var) :- atomic(K), number(K).

% Integral de una variable con respecto a sí misma (ej. x -> 1/2*x^2)
s(Var, Var, 1/2*Var^2) :- atomic(Var).

% --- NUEVA REGLA ---
% Integral de una variable elevada a la N sin constante (ej. x^2 -> 1/3*x^3)
s(Var, Var^N, 1/M*Var^M) :- number(N), M is N+1.

% Integral de constante por variable a la N (ej. 3*x^2 -> 3/3*x^3)
s(Var, K*Var^N, K/M*Var^M) :- atomic(K), number(K), number(N), M is N+1.

% ==========================================
% REGLAS DE SIMPLIFICACIÓN
% ==========================================

% --- SUMA ---
% 1. Constante + Constante (ej. 3 + 5 = 8)
simp(_, K1 + K2, R) :- number(K1), number(K2), R is K1 + K2.

% 2. Variables lineales (ej. x + x = 2*x)
simp(Var, Var + Var, 2*Var) :- atomic(Var).

% 3. Constante por variable lineal (ej. 3*x + 2*x = 5*x)
simp(Var, K1*Var + K2*Var, R*Var) :- number(K1), number(K2), atomic(Var), R is K1 + K2.
simp(Var, Var + K*Var, R*Var) :- number(K), atomic(Var), R is 1 + K.
simp(Var, K*Var + Var, R*Var) :- number(K), atomic(Var), R is K + 1.

% 4. Variables con exponente (ej. x^2 + x^2 = 2*x^2)
simp(Var, Var^N + Var^N, 2*Var^N) :- atomic(Var), number(N).

% 5. Constantes por variables con exponente (ej. 3*x^2 + 2*x^2 = 5*x^2)
simp(Var, K1*Var^N + K2*Var^N, R*Var^N) :- number(K1), number(K2), atomic(Var), number(N), R is K1 + K2.
simp(Var, Var^N + K*Var^N, R*Var^N) :- number(K), atomic(Var), number(N), R is 1 + K.
simp(Var, K*Var^N + Var^N, R*Var^N) :- number(K), atomic(Var), number(N), R is K + 1.


% --- RESTA ---
% 1. Constante - Constante (ej. 5 - 3 = 2)
simp(_, K1 - K2, R) :- number(K1), number(K2), R is K1 - K2.

% 2. Variables lineales (ej. x - x = 0)
simp(Var, Var - Var, 0) :- atomic(Var).

% 3. Constante por variable lineal (ej. 5*x - 2*x = 3*x)
simp(Var, K1*Var - K2*Var, R*Var) :- number(K1), number(K2), atomic(Var), R is K1 - K2.
simp(Var, Var - K*Var, R*Var) :- number(K), atomic(Var), R is 1 - K.
simp(Var, K*Var - Var, R*Var) :- number(K), atomic(Var), R is K - 1.

% 4. Variables con exponente (ej. x^2 - x^2 = 0)
simp(Var, Var^N - Var^N, 0) :- atomic(Var), number(N).

% 5. Constantes por variables con exponente (ej. 5*x^2 - 2*x^2 = 3*x^2)
simp(Var, K1*Var^N - K2*Var^N, R*Var^N) :- number(K1), number(K2), atomic(Var), number(N), R is K1 - K2.
simp(Var, Var^N - K*Var^N, R*Var^N) :- number(K), atomic(Var), number(N), R is 1 - K.
simp(Var, K*Var^N - Var^N, R*Var^N) :- number(K), atomic(Var), number(N), R is K - 1.