personaje(eric).
personaje(timmy).
personaje(kelvin).
personaje(virginia).

protagonista(eric).
edad(eric, 30).

aliado(kelvin).
capturado(kelvin).
mudo(kelvin).

mutante(virginia).
puede_volverse_aliado(virginia).

tiene(eric, encendedor).
tiene(eric, hacha).

puede(kelvin, cargar_troncos).
puede(kelvin, construir).

zona(superficie).
zona(cuevas).
zona(bunker).

enemigos(canibales).
enemigos(mutantes).

aparece_en(canibales, superficie).
aparece_en(mutantes, superficie).
aparece_en(mutantes, cuevas).

requiere_llave(bunker).

nivel_peligro(superficie, medio, dia).
nivel_peligro(superficie, alto, noche).
nivel_peligro(cuevas, alto).

necesita(eric, refugio).
necesita(eric, comida).
necesita(eric, agua).

hay_en(troncos, superficie).
hay_en(piedras, superficie).