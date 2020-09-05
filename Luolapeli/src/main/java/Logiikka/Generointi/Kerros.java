package Logiikka.Generointi;

import Logiikka.Ruudukko.Ruudukko;
import Logiikka.Ruudukko.Ruutu;

/**
 * Olio on vastuussa Luolapelin koko kerroksen kaikesta tiedosta ja sen
 * käsittelystä.
 *
 * @author htommi
 */
public class Kerros {

    private Ruudukko ruudukko;
    private AluePuu ap;

    /**
     * Luo uuden Kerros olion. Se tarvitsee koko kerroksen koon ja moneen
     * Alueeseen se on jaettu.
     *
     * @param koko kerroksen koko
     * @param jakauksia moneen osaan kerros on jaettu
     */
    public Kerros(int koko, int jakauksia) {
        ruudukko = new Ruudukko(koko);
        ap = new AluePuu(koko, jakauksia);
    }

    /**
     * Paivittaa ruuduille tiedon siitä, millä alueella ne ovat.
     */
    public void alueetRuudukkoon() {
        for (int y = 0; y < this.getRuudukko().getKoko(); y++) {
            for (int x = 0; x < this.getRuudukko().getKoko(); x++) {
                this.ruudukko.setRuudunAlue(x, y, ap.getAlueet()[0].getHuone()[x][y]);
                this.ruudukko.setRuudunArvo(x, y, ap.getAlueet()[0].getHuone()[x][y]);
            }
        }
    }

    public AluePuu getAluePuu() {
        return ap;
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    public Alue[] getAlimmatAlueet() {
        int a = ap.indexMistaAlkaaTaso(ap.MAXTASO);
        int k = ap.montaSolmuaTasolla(ap.MAXTASO);
        Alue[] alimmat = new Alue[k];
        int i = 0;
        for (int p = a; p < k + a; p++) {
            alimmat[i] = ap.getAlueet()[p];
            i++;
        }
        return alimmat;
    }

    public Ruutu annaSijaintiAlueesta(int id) {
        Alue alue = this.ap.getAlueet()[id];
        Ruutu ruutu = alue.annaEkaTyhjaRuutu();
        return ruutu;
    }

}
