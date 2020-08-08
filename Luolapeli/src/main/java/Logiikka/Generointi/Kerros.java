
package Logiikka.Generointi;

import Logiikka.Generointi.AluePuu;
import Logiikka.Ruudukko.Ruudukko;

public class Kerros {
    private Ruudukko ruudukko;
    private AluePuu ap;
    
    /**
     * Olio on vastuussa koko kerroksen kaikesta tiedosta ja sen käsittelystä.
     * 
     * @param koko kerroksen koko
     * @param jakauksia moneen osaan kerros on jaettu
     */
    Kerros(int koko, int jakauksia) {
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
     * @param taso antaa ruuduille AluePuusta alueen sen mukaan millä tasolla se on puussa. Jos annettu taso on isompi kuin alin taso, annetaan alin taso.
     */
    public void alueetRuudukkoon(int taso) {
        if (taso > ap.MAXtaso) {
            taso = ap.MAXtaso;
        }
        int a = ap.montaSolmuaTasolla(taso);
        int b = ap.indexMistaAlkaaTaso(taso);
        for (int i = b; i < a + b; i++) {
            Alue alue = ap.getAlueet()[i];
            System.out.println("aaaaaaaaaaaaa kun i = " + i + " ja alue: " + alue.getKoko());
            System.out.println("samalla x ja y: " + alue.getX() + " ja " + alue.getY());
            
            for (int y = alue.getY(); y < alue.getPituusy(); y++) {
                for (int x = alue.getX(); x < alue.getPituusx(); x++) {
                    this.ruudukko.setRuudunAlue(x, y, i);
                }
            }
        }
    }
    
    
}
