package Logiikka.Generointi;

/**
 *
 * Luokka joka pitää yllä puurakennetta, jossa on helppo käsitellä Luolapelin
 * kerroksia jotka on jaettu alueisiin. Syy puun olemassaololle on se, että
 * aluista voi esimerkiksi helposti satunnaisesti valita mistä alueesta pelaaja
 * aloittaa tai minne syntyy vihollisia nje. Helpottaa myös huoneiden
 * yhdistämistä käytävillä.
 *
 * @author htommi
 */
public class AluePuu {

    private Alue[] alueet;
    final int MAXTASO;

    /**
     * Lue uuden AluePuu olion.
     *
     * @param jakauksia Monta kertaa halutaan kerros jakaa ali-Alueisiin, 0 = 1
     * iso alue, 1 = alue jaettu kahteen, 2 = alue jaettu neljään ja niin
     * edespäin, alinpien alialueiden määrä aina kaksinkertaistuu.
     * @param koko Koko kerroksen koko.
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
        MAXTASO = jakauksia;
    }

    public Alue[] getAlueet() {
        return alueet;
    }

    /**
     * Palauttaa solmujen maaran puun tasolla.
     *
     * @param taso.
     * @return solmujen maara.
     */
    public int montaSolmuaTasolla(int taso) {
        int p = 1;
        for (int i = 0; i < taso; i++) {
            p = p * 2;
        }
        return p;
    }

    /**
     * Kertoo indeksin taulukosta josta alkaa haluttu taso.
     *
     * @param taso
     * @return index tasolle
     */
    public int indexMistaAlkaaTaso(int taso) {
        int p = 0;
        for (int i = 0; i < taso; i++) {
            p += montaSolmuaTasolla(i);
        }
        return p;
    }

}
