<?php
require 'vendor/autoload.php';

use Holjevac\Utakmica;
// https://flightphp.com/learn
// preporuka https://medium.com/@h.benkachoud/symfony-rest-api-without-fosrestbundle-and-using-jwt-authentication-part-1-944aa4faf946
Flight::route('GET /v1/utakmice',function(){

    $utakmica = new Utakmica();

    Flight::json($utakmica->getUtakmice());

});

Flight::map('notFound',function(){
    print_r($_SERVER);
   
});



Flight::start();