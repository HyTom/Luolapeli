
package Logiikka;

import Logiikka.Ruudukko.Ruudukko;
import java.util.Random;

public class Luolageneraattori {
    
    /**
     * Luo luolapeliin tarkoitetun kerroksen käyttämällä sille annettua lukua.
     * HUOM tällä hetkellä ruudukon koko on kovakoodattu 10.
     * 
     * @param seed 
     * @param onkoPysty 1 niin pystyrivi, 0 niin vaaka
     */
    public Ruudukko luoKerros(int seed, int onkoPysty) {
        Ruudukko ruudukko = new Ruudukko(10);
        
        jaaRuudukko(ruudukko, onkoPysty, seed);
        
        return ruudukko;
    }

    /**
     * 
     * @param ruudukko
     * @param onkoPysty 1 niin pystyrivi, 0 niin vaaka
     * @param seed 
     */
    private void jaaRuudukko(Ruudukko ruudukko, int onkoPysty, int seed) {
        if (onkoPysty == 1) {
            for (int y = 0; y < ruudukko.getKoko(); y++) {
                ruudukko.lisaaRuutu(seed, y, 1);
            }
        } else {
            for (int x = 0; x < ruudukko.getKoko(); x++) {
                ruudukko.lisaaRuutu(x, seed, 1);
            }
        }
    }
    
}
