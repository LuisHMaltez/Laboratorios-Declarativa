#lang racket

;; Actividad evaluada
;; Devuelve el interes asignado a un deposito segun estas tasas:
;;   deposito <= 40,000           -> 3.5%
;;   40,000 < deposito <= 260,000 -> 4%
;;   deposito > 260,000           -> 4.5%

(define (tasa-interes deposito)
  (cond
    [(<= deposito 40000) 3.5]
    [(<= deposito 260000) 4]
    [else 4.5]))

(define (interes deposito)
  (/ (* deposito (tasa-interes deposito)) 100))

;; Pruebas
(displayln (interes 30000))   ; 1050.0
(displayln (interes 40000))   ; 1400.0
(displayln (interes 100000))  ; 4000
(displayln (interes 260000))  ; 10400
(displayln (interes 300000))  ; 13500.0

;Luis Andrée Hernández Maltez - 00012321