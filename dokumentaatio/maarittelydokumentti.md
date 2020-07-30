# Määrittelydokumentti
(Paivitetty viikolla 2)

Tavoitteena on siis tehdä luolastogeneraattoriin pohjautuva peli Javalla.
Algoritmeja sen toteuttamiseen löytyy useita ja yksi jonka koin näppärän tuntuiseksi on [Binary space partitioning (BSP)](https://en.wikipedia.org/wiki/Binary_space_partitioning), (eli suomeksi [binäärinen avaruuden osiointi](https://fi.wikipedia.org/wiki/Binary_space_partitioning)). 
Tämä sivu kertoo todella hyvin mistä asiassa on kyse:

http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation

Eli ideana on jakaa ruudukko alueisiin, luoda alueiden sisälle huoneita ja sitten linkittää huoneet käytävillä.

Projektin suunnittelu on vielä kesken (päivitän tätä dokumenttia tarkemmilla yksityiskohdilla) mutta tiedän pelistä ainakin seuraavat asiat:
* Peli toimii ruudukossa.
* Peli on vuoropohjainen.
* Luolastosta tulee olla reitti aloituspaikasta uloskäynnille. 
* Luolasto on jaettu tasoihin, joten joka kerrokselle tulee luoda oma luolasto.
* Uusi luola generoituu siis hahmon liikkuessa uloskäynnille.

Lisäksi haluan että luolastossa on vähintää yksi vihollinen. Näinollen haluan myös luoda sille reitinhakualgoritmin (Dijkstra?). Se liikkuu aina kun pelaajakin liikkuu, tai se voiko se liikkua arvotaan.

Laitan tähän tavoitteena olevat aika ja tilavaatimukset heti kun ne on selvillä.

Lähteet:
https://en.wikipedia.org/wiki/Binary_space_partitioning
https://fi.wikipedia.org/wiki/Binary_space_partitioning
http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
