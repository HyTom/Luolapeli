
package Logiikka.Generointi;

import Logiikka.Ruudukko.Ruudukko;

public class AluePuu {
    private Alue[] alueet;
    final int MAXtaso;

    /**
    * Luokka joka pitää yllä puurakennetta, jossa on helppo käsitellä Luolapelin kerroksia jotka on jaettu alueisiin.
    * Syy puun olemassaololle on se, että aluista voi esimerkiksi helposti satunnaisesti valita mistä alueesta pelaaja aloittaa
    * tai minne syntyy vihollisia nje. Helpottaa myös huoneiden yhdistämistä käytävillä.
    * @param jakauksia 
    * @param koko taulukossa
    */
    public AluePuu(int koko, int jakauksia) {
        int s = 1;
        if (jakauksia > 0) {
            int a = 1;
            for (int i = 0; i < jakauksia; i++) {
                a = a * 2;
                s += a;
            }
        }
        this.alueet = new Alue[s];
        Alue alue = new Alue(1, 0, 0, koko, koko);
        this.alueet[0] = alue;
        MAXtaso = jakauksia + 1;
    }

    public Alue[] getAlueet() {
        return alueet;
    }

    public int montaSolmuaTasolla(int taso) {
        int p = 1;
        for (int i = 0; i < taso; i++) {
            p = p * 2;
        }
        return p;
    }

    public int indexMistaAlkaaTaso(int taso) {
        int p = 0;
        for (int i = 0; i < taso; i++) {
            p += montaSolmuaTasolla(i);
        }
        return p;
    }
    
}
