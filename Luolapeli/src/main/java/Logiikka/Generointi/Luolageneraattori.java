package Logiikka.Generointi;

import java.util.Random;

/**
 * Luokka joka hallitsee Luolapeliin generoitavien luolien luomisesta.
 *
 * @author htommi
 */
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
     * @param jakaumat Moneen osaan luola on jaettu, isompi luku tarkoittaa
     * enemmän huoneita.
     * @param koko Luolan koko x * x
     *
     */
    public Kerros luoKerros(int jakaumat, int koko) {

        //Luo kerros olio joka lopuksi palautetaan
        Kerros kerros = new Kerros(koko, jakaumat);

        //Jaetaan kerros alueisiin
        luoAlueet(kerros.getAluePuu().getAlueet(), jakaumat);

        //luodaan alueisiin huoneet
        luoHuoneet(kerros.getAluePuu());

        //luodaan huoneiden välille niitä yhdistävät käytävät
        //Alustetaan ja palautetaan pelivalmis kerros
        kerros.alueetRuudukkoon(jakaumat);
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
                int onkoPysty = r.nextInt(2);
                if (alue[j].getPituusx() == 1) {
                    onkoPysty = 0;
                }
                if (alue[j].getPituusy() == 1) {
                    onkoPysty = 1;
                }
                if (onkoPysty == 1) {
                    int apu = annaSopivaJakauma(alue[j].getPituusx(), jakaumat - i);
                    alue[2 * j + 1] = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), apu, alue[j].getPituusy());
                    alue[2 * j + 2] = new Alue(2 * j + 1, alue[j].getX() + apu, alue[j].getY(), alue[j].getPituusx() - apu, alue[j].getPituusy());
                } else {
                    int s = alue[j].getPituusy() / 2;
                    int apu = annaSopivaJakauma(alue[j].getPituusy(), jakaumat - i);
                    alue[2 * j + 1] = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), alue[j].getPituusx(), apu);
                    alue[2 * j + 2] = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY() + apu, alue[j].getPituusx(), alue[j].getPituusy() - apu);
                }
            }
            n = m;
            m = 2 * m + 1;
        }

    }

    private int annaSopivaJakauma(int p, int j) {
        int a = r.nextInt(p);
        if (a >= p - j) {
            a = p - j;
        }
        if (a <= j) {
            a = j;
        }
        if (p == j) {
            a = p / 2;
        }
        return a;
    }

    /**
     * Käy läpi kaikki alimman solmun kerrokset ja luo niihin satunnaisen
     * huoneen.
     *
     * @param ap Aluepuu olio.
     */
    private void luoHuoneet(AluePuu ap) {
        Huonegeneraattori hg = new Huonegeneraattori();
        int m = ap.montaSolmuaTasolla(ap.MAXTASO);
        int a = ap.indexMistaAlkaaTaso(ap.MAXTASO);
        for (int i = a; i < a + m; i++) {
            hg.luoHuone(ap.getAlueet()[i]);
        }
    }

}
