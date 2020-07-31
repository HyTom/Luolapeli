
import Logiikka.Luolageneraattori;
import Logiikka.Ruudukko.Ruudukko;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Tällä hetkellä main() vain testaa Luolageneraattorin toimintaa.
        
        Luolageneraattori lg = new Luolageneraattori();
        
        //Javan Random luokkaa ei periaatteessa saa käyttää, ja se korvataankin tulevaisuudessa nanotimella
        Random random = new Random();
        int seed = random.nextInt(8) + 1;
        System.out.println("seed: " + seed);
        
        Ruudukko level1 = lg.luoKerros(seed, random.nextInt(2));
        
        //Luolan tulostaminen ennen UI:ta.
        tulostaRuudukko(level1);
     
    }

    private static void tulostaRuudukko(Ruudukko level) {
        int k = level.getKoko();
        System.out.println("Luolan koko: " + k + "\n");
        for (int x = 0; x < k; x++) {
            System.out.println("\n");
            for (int y = 0; y < k; y++) {
                if (level.ruutuIsEmpty(x, y)) {
                    System.out.print("0 ");
                } else {
                    System.out.print("- ");
                }
            }
        }
    }
    
}
