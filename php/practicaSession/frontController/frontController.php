<?php
require_once 'config/Config.php';



/**
 * Description of FrontController
 *
 * @author DAW
 */
 use candados\Candado1;
 use candados\Candado2;
 use candados\Candado3;

 
$pass = $_REQUEST[Constantes::REQUEST_KEY];


if ($_SESSION[Constantes::SESSION_KEY] == NULL){
    $_SESSION[Constantes::SESSION_KEY]="0";
}

switch ($_SESSION[\Constantes::SESSION_KEY]) {
    case 0:
        //controller1
       $controller= new Candado1($pass);

        break;

    case 2.1:
        //controller2
        $controller= new Candado2($pass);
        break;
    
    case 2.2:
        //controller2
        $controller= new Candado2($pass);
        break;
    
    case 2.3:
        //controller2
        $controller= new Candado2($pass);
        break;
    
    case 3:
        //controller3
        $controller= new Candado3($pass);
        break;
    
    default :
        //controller1 " error "
        $controller= new Candado1($pass);
        break;
}

$controller->siguiente();