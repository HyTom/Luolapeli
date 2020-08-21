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

        //luodaan huoneita yhdistävät käytävät jos tarve
        if (jakaumat > 0) {
            luoKaytavat(kerros.getAluePuu());
        }

        //Alustetaan huoneet
        //kerros.alueetRuudukkoon2(jakaumat);
        kerros.alueetRuudukkoon();

        //Palautetaan pelivalmis kerros
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
                    Alue eka = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), apu, alue[j].getPituusy());
                    Alue toka = new Alue(2 * j + 2, alue[j].getX() + apu, alue[j].getY(), alue[j].getPituusx() - apu, alue[j].getPituusy());
                    alue[2 * j + 1] = eka;
                    alue[2 * j + 2] = toka;
                    eka.setOnkoPysty(true);
                    toka.setOnkoPysty(true);
                } else {
                    int apu = annaSopivaJakauma(alue[j].getPituusy(), jakaumat - i);
                    Alue eka = new Alue(2 * j + 1, alue[j].getX(), alue[j].getY(), alue[j].getPituusx(), apu);
                    Alue toka = new Alue(2 * j + 2, alue[j].getX(), alue[j].getY() + apu, alue[j].getPituusx(), alue[j].getPituusy() - apu);
                    alue[2 * j + 1] = eka;
                    alue[2 * j + 2] = toka;
                    eka.setOnkoPysty(false);
                    toka.setOnkoPysty(false);
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
        //yhdistetaan huoneet ylemmille tasoille
        //ylemmilleAlueilleHuoneet(ap, ap.MAXTASO - 1);
    }

    /**
     * Luo huoneita yhdistavat kaytavat jos on tarve.
     *
     * @param aluePuu Tarvitaan jotta saadaan alueet.
     */
    private void luoKaytavat(AluePuu ap) {
        //esim. leikkaus 3:
        // yhdistä 7 ja 8, 9 ja 10 nje...
        // sitten yhdista 3 ja 4 sekä 5 ja 6
        // lopulta 1 ja 2
        for (int taso = ap.MAXTASO - 1; taso >= 0; taso--) {
            int m = ap.montaSolmuaTasolla(taso);
            int a = ap.indexMistaAlkaaTaso(taso);
            for (int i = a; i < a + m; i++) {
                Alue eka = ap.getAlueet()[i * 2 + 1];
                Alue toka = ap.getAlueet()[i * 2 + 2];
                yhdistaHuoneet(eka, toka);
                //System.out.println("solmun eka " + eka.getId() + " ja toka " + toka.getId() + " esivanhempi on " + (i / 2));
                //System.out.println("eka x,y: (" + eka.getX() + ", " + eka.getY() + ")");
                //System.out.println("toka x,y: (" + toka.getX() + ", " + toka.getY() + ")");
            }
            ylemmilleAlueilleHuoneet(ap, taso);
        }
    }

    /**
     * Yhdistaa alempien alueiden huoneet ylemmälle alueelle omaksi huoneeksi.
     * Huone on a x a taulukko ja sen arvona on alimman tason huoneen id.
     * Helpottaa teiden tekoa, koska tiet luolaan alhaalta ylöspäin tasoissa.
     *
     * @param ap Aluepuu
     * @param taso Taso puussa johon halutaan huone generoida
     */
    private void ylemmilleAlueilleHuoneet(AluePuu ap, int taso) {
        int m = ap.montaSolmuaTasolla(taso);
        int a = ap.indexMistaAlkaaTaso(taso);
        for (int j = a; j < a + m; j++) {
            Alue eka = ap.getAlueet()[j * 2 + 1];
            Alue toka = ap.getAlueet()[j * 2 + 2];
            Alue master = ap.getAlueet()[j];
            System.out.println("master id: " + master.getId());
            System.out.println("eka pituusx ja y: " + eka.getPituusx() + ", " + eka.getPituusy());
            System.out.println("toka pituusx ja y: " + toka.getPituusx() + ", " + toka.getPituusy());
            System.out.println("master pituusx ja y: " + master.getPituusx() + ", " + master.getPituusy());
            for (int y = 0; y < eka.getPituusy(); y++) {
                for (int x = 0; x < eka.getPituusx(); x++) {
                    if (eka.getHuone()[x][y] >= 1) {
                        master.getHuone()[x][y] = eka.getHuone()[x][y];
                    }
                }
            }
            int aloitusx = 0;
            int aloitusy = 0;
            if (eka.isOnkoPysty()) {
                aloitusx = eka.getPituusx();
            } else {
                aloitusy = eka.getPituusy();
            }
            for (int y = 0; y < toka.getPituusy(); y++) {
                for (int x = 0; x < toka.getPituusx(); x++) {
                    if (toka.getHuone()[x][y] >= 1) {
                        master.getHuone()[x + aloitusx][y + aloitusy] = toka.getHuone()[x][y];
                    }
                }
            }
        }
    }

    private void yhdistaHuoneet(Alue eka, Alue toka) {
        if (eka.isOnkoPysty()) {
            yhdistaHuoneetPysty(eka, toka);
        } else {
            yhdistaHuoneetVaaka(eka, toka);
        }
    }

    private void yhdistaHuoneetPysty(Alue eka, Alue toka) {
        int ekax = -1;
        int ekay = -1;
        for (int x = eka.getPituusx() - 1; x >= 0; x--) {
            for (int y = eka.getPituusy() - 1; y >= 0; y--) {
                if (eka.getHuone()[x][y] >= 1) {
                    ekax = x;
                    ekay = y;
                    break;
                }
            }
            if (ekax != -1 & ekay != -1) {
                break;
            }
        }
        int tokax = -1;
        int tokay = -1;
        for (int x = 0; x < toka.getPituusx(); x++) {
            for (int y = 0; y < toka.getPituusy(); y++) {
                if (toka.getHuone()[x][y] >= 1) {
                    tokax = x;
                    tokay = y;
                    break;
                }
            }
            if (tokax != -1 & tokay != -1) {
                break;
            }
        }
        System.out.println("vasen (" + eka.getId() + ") x ja y: " + ekax + ", " + ekay);
        System.out.println("oikea (" + toka.getId() + ") x ja y: " + tokax + ", " + tokay);
        System.out.println("----");
        for (int x = ekax; x < eka.getPituusx(); x++) {
            eka.getHuone()[x][ekay] = eka.getId();
        }
        if (tokay > ekay) {
            for (int y = tokay; y >= ekay; y--) {
                toka.getHuone()[tokax][y] = toka.getId();
                tokay = y;
            }
        } else if (tokay < ekay) {
            for (int y = tokay; y <= ekay; y++) {
                toka.getHuone()[tokax][y] = toka.getId();
                tokay = y;
            }
        }
        for (int x = tokax; x >= 0; x--) {
            toka.getHuone()[x][tokay] = toka.getId();
        }
    }

    private void yhdistaHuoneetVaaka(Alue eka, Alue toka) {
        int ekax = -1;
        int ekay = -1;
        for (int y = eka.getPituusy() - 1; y >= 0; y--) {
            for (int x = eka.getPituusx() - 1; x >= 0; x--) {
                if (eka.getHuone()[x][y] >= 1) {
                    ekax = x;
                    ekay = y;
                    break;
                }
            }
            if (ekax != -1 & ekay != -1) {
                break;
            }
        }
        int tokax = -1;
        int tokay = -1;
        for (int y = 0; y < toka.getPituusy(); y++) {
            for (int x = 0; x < toka.getPituusx(); x++) {
                if (toka.getHuone()[x][y] >= 1) {
                    tokax = x;
                    tokay = y;
                    break;
                }
            }
            if (tokax != -1 & tokay != -1) {
                break;
            }
        }
        System.out.println("vasen (" + eka.getId() + ") x ja y: " + ekax + ", " + ekay);
        System.out.println("oikea (" + toka.getId() + ") x ja y: " + tokax + ", " + tokay);
        System.out.println("||||");
        for (int y = ekay; y < eka.getPituusy(); y++) {
            eka.getHuone()[ekax][y] = eka.getId();
        }
        if (tokax > ekax) {
            for (int x = tokax; x >= ekax; x--) {
                toka.getHuone()[x][tokay] = toka.getId();
                tokax = x;
            }
        } else if (tokax < ekax) {
            for (int x = tokax; x <= ekax; x++) {
                toka.getHuone()[x][tokay] = toka.getId();
                tokax = x;
            }
        }
        for (int y = tokay; y >= 0; y--) {
            toka.getHuone()[tokax][y] = toka.getId();
        }
    }

}
