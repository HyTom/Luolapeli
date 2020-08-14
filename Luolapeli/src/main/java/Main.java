
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
        int koko = 30;
        int jakaumat = 4;
        Kerros level1 = lg.luoKerros(jakaumat, koko);
        
        //Luolan tulostaminen ennen UI:ta.
        System.out.println("Luolan koko: " + koko + "\n");
        tulostaAlueet(level1.getRuudukko());
        tulostaHuoneet(level1.getRuudukko());
     
    }

    private static void tulostaAlueet(Ruudukko level) {
        int k = level.getKoko();
        System.out.println("Alueet:");
        for (int y = 0; y < k; y++) {
            System.out.println("\n");
            for (int x = 0; x < k; x++) {
                    System.out.print(" " + level.getRuutu(x, y).getAlue());
            }
        }
        System.out.println("\n---------------------------------------");
        System.out.println("");
    }
    
    private static void tulostaHuoneet(Ruudukko level) {
        int k = level.getKoko();
        System.out.println("Huoneet:");
        for (int y = 0; y < k; y++) {
            System.out.println("\n");
            for (int x = 0; x < k; x++) {
                if (level.getRuutu(x, y).getArvo() == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.print("[ ]");
                }
            }
        }
        System.out.println("\n---------------------------------------");
        System.out.println("");
    }
    
}
