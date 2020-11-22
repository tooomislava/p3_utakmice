<?php
namespace Holjevac;

use stdClass;
use Faker\Factory;

class Utakmica
{
    public function getUtakmice()
    {
        $faker = \Faker\Factory::create();
        $faker->addProvider(new \Bezhanov\Faker\Provider\Team($faker));
        $utakmice=[];
        //dovući podatke iz baze
        for($i=1;$i<=100;$i++){
            $u = new stdClass();
            $u->sifra=$i;
            $u->domacin=$faker->team;
            $u->gost=$faker->team;
            $score1 = rand(0,5);
            $score2 = rand(0,5);
            $u->rezultat= $score1.":".$score2;
            if($u->sifra === 1){
                $u->domacin="Osijek";
                $u->gost="Dinamo";
                $u->rezultat="2:0";
            }
            $utakmice[]=$u;
        }
        return $utakmice;
    }
}