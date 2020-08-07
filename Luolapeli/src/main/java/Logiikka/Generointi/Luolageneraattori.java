package Logiikka.Generointi;

import Logiikka.Ruudukko.Ruudukko;
import java.util.Random;

public class Luolageneraattori {

    private Random r;

    /**
     * Luokka joka hallitsee Luolapeliin generoitavien luolien luomisesta.
     */
    public Luolageneraattori() {
        r = new Random();
    }

    /**
     * Luo luolapeliin tarkoitetun kerroksen joka on kokoa parametri koko *
     * koko. Ensin ruudukko jaetaan alueisiin x kertaa (joka voi myöhemmin olla
     * parametri). Sitten alueiden sisälle generoidaan huone, ja lopuksi huoneet
     * yhdistetään käytävillä. Palautettu olio Kerros sisältää ruudukon mutta
     * olisi hyvä että se sisältäisi myös huoneiden sijainnit ja kukin ruutu
     * tietäisi mitä aluetta se on osana(?).
     *
     * @param seed
     * @param onkoPysty 1 niin pystyrivi, 0 niin vaaka
     * @param koko Luolan koko x * x
     */
    public Kerros luoKerros(int seed, int koko) {
        //tällä hetkellä jakaa huoneet 2 kertaa testaamisen helpottamiseksi.
        int jakaumat = 2;

        //Luo kerros olio joka lopuksi palautetaan
        Kerros kerros = new Kerros(koko, jakaumat);

        //Jaetaan kerros alueisiin
        luoAlueet(kerros.getAluePuu().getAlueet(), jakaumat);
        kerros.alueetRuudukkoon(jakaumat);

        //Jotain
        //Palautetaan pelivalmis kerros
        return kerros;
    }

    /**
     * Metodi jakaa ruudukon alueisiin joiden sisälle luodaan huoneet.
     *
     * @param ruudukko
     * @param seed
     */
    private void luoAlueet(Alue[] alue, int jakaumat) {
        int n = 0;
        int m = 1;
        for (int i = 0; i < jakaumat; i++) {
            for (int j = n; j < m; j++) {
                int px = alue[n];
                System.out.println("k???" + k);
                int s = r.nextInt(k);
                int onkoPysty = r.nextInt(2);
                if (onkoPysty == 1) {
                    //alue[2 * j + 1] = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), k - s, k);
                    //alue[2 * j + 2] = new Alue(2 * j + 2, alue[j].getX() + (k-s), alue[j].getY(), s, k);
                } else {
                    //alue[2 * j + 1] = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), k - s);
                    //alue[2 * j + 2] = new Alue(2 * j + 2, alue[j].getX(), alue[j].getY() + (k-s), s);
                }
            }
            n += m;
            m = 2 * m + 1;
        }

    }

}
