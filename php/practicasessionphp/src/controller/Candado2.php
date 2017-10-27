<?php

namespace controller;

/**
 * Description of Candado2
 *
 * @author DAW
 */
class Candado2 {

    public function siguiente($param) {
        $paginaSalida = \Constantes::PAGINA_ERROR;
        $valorSession = 0;
        echo "candado2Inicio <br>";
        if (($param != NULL)) {

            //nivel 2.1
            if ($_SESSION[\Constantes::SESSION_KEY] == 2) {
                if (strcmp($param, \Constantes::PASS_2_1) == 0) {
                    $paginaSalida = \Constantes::PAGINA_INTERMEDIA;
                    $valorSession = 3;
                    echo "candado2Fin <br>";
                }
            }

            //nivel 2.2
            if ($_SESSION[\Constantes::SESSION_KEY] == 3) {
                if (strcmp($param, \Constantes::PASS_2_2) == 0) {
                    $paginaSalida = \Constantes::PAGINA_INTERMEDIA;
                    $valorSession = 4;
                    echo "candado2Fin <br>";
                }
            }

            //nivel 2.3
            if ($_SESSION[\Constantes::SESSION_KEY] == 4) {
                if (strcmp($param, \Constantes::PASS_2_3) == 0) {
                    $paginaSalida = \Constantes::PAGINA_INTERMEDIA;
                    $valorSession = 5;
                    echo "candado2Fin <br>";
                }
            }
        }

        $_SESSION[\Constantes::SESSION_KEY] = $valorSession;
        include $paginaSalida;
    }

}
