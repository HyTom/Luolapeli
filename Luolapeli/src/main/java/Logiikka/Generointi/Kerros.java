package Logiikka.Generointi;

import Logiikka.Ruudukko.Ruudukko;

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

    AluePuu getAluePuu() {
        return ap;
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    /**
     * Paivittaa ruuduille tiedon siitä, millä alueella ne ovat.
     *
     * @param taso antaa ruuduille AluePuusta alueen sen mukaan millä tasolla se
     * on puussa. Jos annettu taso on isompi kuin alin taso, annetaan alin taso.
     */
    public void alueetRuudukkoon2(int taso) {
        if (taso > ap.MAXTASO) {
            taso = ap.MAXTASO;
        }
        int a = ap.montaSolmuaTasolla(taso);
        int b = ap.indexMistaAlkaaTaso(taso);
        for (int i = b; i < a + b; i++) {
            Alue alue = ap.getAlueet()[i];

            for (int y = alue.getY(); y < alue.getY() + alue.getPituusy(); y++) {
                for (int x = alue.getX(); x < alue.getX() + alue.getPituusx(); x++) {
                    this.ruudukko.setRuudunAlue(x, y, i);
                    this.ruudukko.getRuutu(x, y).setArvo(alue.onkoKohdassaHuonetta(x - alue.getX(), y - alue.getY()));
                }
            }
        }
    }

    void alueetRuudukkoon() {
        for (int y = 0; y < this.getRuudukko().getKoko(); y++) {
            for (int x = 0; x < this.getRuudukko().getKoko(); x++) {
                this.ruudukko.setRuudunAlue(x, y, ap.getAlueet()[0].getHuone()[x][y]);
                this.ruudukko.setRuudunArvo(x, y, ap.getAlueet()[0].getHuone()[x][y]);
            }
        }
    }

}
