:- consult('hechos.pl').

zona_totalmente_segura(Zona) :-
    zona(Zona),
    \+ aparece_en(canibales, Zona),
    \+ aparece_en(mutantes, Zona).

puedo_ordenar_tarea(Solicitante, Tarea) :-
    protagonista(Solicitante),
    aliado(kelvin),
    puede(kelvin, Tarea).

zona_alto_riesgo(Zona, Momento) :-
    nivel_peligro(Zona, alto) ; 
    nivel_peligro(Zona, alto, Momento).

protagonista_equipado(Personaje) :-
    protagonista(Personaje),
    tiene(Personaje, hacha),
    tiene(Personaje, encendedor).