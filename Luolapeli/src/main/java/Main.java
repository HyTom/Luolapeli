
import Logiikka.Generointi.Luolageneraattori;
import Logiikka.Ruudukko.Ruudukko;
import Logiikka.Generointi.Kerros;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Tällä hetkellä main() vain testaa Luolageneraattorin toimintaa.
        //Luodaan myöhemmin Peli luokka joka ohjaa pelin toimintaa, ja esim antaa Luolageneraattorille
        //satunnaiset luvut jota se käyttää. Olisi hyvä että vain antamalla luolan koon se osaa arpoa hyviä lukuja jotta
        //luolan jakaminen ei johda alusta lähtien liian ahtaisiin jakaumiin.
        
        Luolageneraattori lg = new Luolageneraattori();
        
        //Javan Random luokkaa ei periaatteessa saa käyttää, ja se korvataankin tulevaisuudessa nanotimella
        Random random = new Random();
        int koko = 20;
        int seed = random.nextInt(koko - 2) + 1;
        System.out.println("seed: " + seed);
        
        Kerros level1 = lg.luoKerros(seed, koko);
        
        //Luolan tulostaminen ennen UI:ta.
        tulostaRuudukko(level1.getRuudukko());
     
    }

    private static void tulostaRuudukko(Ruudukko level) {
        int k = level.getKoko();
        System.out.println("Luolan koko: " + k + "\n");
        for (int x = 0; x < k; x++) {
            System.out.println("\n");
            for (int y = 0; y < k; y++) {
                //if (level.ruutuIsEmpty(x, y)) {
                    System.out.print(" " + level.getRuutu(x, y).getAlue());
                //} else {
                    //System.out.print("* ");
                //}
            }
        }
    }
    
}
