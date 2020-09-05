Ohjelman rakenne:
UI:lle annetaan peli.
Pelillä on luolageneraattori, jolta se aina pyytää uuden kerrosolion.
Kerros luodaan jakamalla k*k kokoinen ruudukko kahtia ja syntyvät alueet ja niiden alialueet (ja niin edelleen) kahtia x kertaa luoden siitä puu.
Leikkauskohta sekä onko se vaaka vai pysty rivi arvotaan.

Puun alimpiin kerroksiin luodaan huoneet.
Tämän jälkeen alimpien kerroksien ruudukot yhdistetään alueiden vanhemmille puussa samalla niitä teillä yhdistäen.
Lopulta puussa kohdassa 0 on koko taulukko, jossa jos ruutu on 0, se on tyhjä. Jos se ei ole tyhjä, siinä on sen tason id puusta jossa se täytettiin. 

Peli arpoo paikat pelaajalle, uloskäynnille sekä hirviöille.
Pelaajien, uloskäyntien ja hirviöiden sijainti saadaan valitsemalla satunnaisesti alue. Alueen ensimmäinen kohta ylhäällä vasemmalla on se paikka johon kohde laitetaan. Samaa aluetta ei voi valita kahdesti. Alueen sisäisestä huoneesta olisi tietenkin voinut helposti arpoa vielä satunnaisemman sijainnin, mutta tulin siihen tuloksee että se on tarpeeksi hyvä. 

Uusi luola generoidaan ja uudet sijainnit ja hirviöt luodaan aina kun pelaaja pääsee maaliin, kuolee, tai pelaaja painaa nappia "U".

Luola generoituu pelissä aina alta sekunnin. Todella isoilla luvuilla saattaa aikaa kulua enemmän, mutta silloin ruudukko on jo niin iso että peli on pelikelvoton (nykyisellä pelin logiikalla).

Hirviöillä on kevyt tekoäly, jossa ne katsovat 8 suuntaan etsien pelaajaa. Pelaajan nähdessä ne odottavat hetken, ja suuntaavat sinne missä viimeksi näkivät pelaajan. Paikalle saavuttua jos pelaajaa ei näy, ne hetken jälkeen palaavat takaisin tilaan ennen kuin ne näkivät pelaajan.

Hirviöiden tekoälyä olisi voinut hioa, ja luolangeneroimista myös. Parastahan olisi jos luolageneraattori itsessään ei voisi koskaan kaatua, mutta valitettavasti sellaisia lukuja on. Sen sijaan niistä luvuista joilla generaattori ei voi kaatua huolehtii pelin koodi, joka ei ole hyvä.

Pelissä itsessään on asioita joita parantaa, mutta pelin hauskuus ei ole projektille erityisen tärkeää.

Lähteet: 
http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
(Random) https://stackoverflow.com/questions/13442611/how-can-i-generate-a-random-number-without-use-of-math-random
