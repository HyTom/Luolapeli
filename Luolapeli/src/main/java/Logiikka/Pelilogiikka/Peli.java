package Logiikka.Pelilogiikka;

import Logiikka.Generointi.Alue;
import Logiikka.Generointi.Kerros;
import Logiikka.Generointi.Luolageneraattori;
import Logiikka.Generointi.Satunnainen;
import Logiikka.Ruudukko.Ruudukko;
import Logiikka.Ruudukko.Ruutu;

public class Peli {

    private Luolageneraattori lg;
    private Kerros kerros;
    private Pelaaja pelaaja;
    private Portaat portaat;
    private Satunnainen r;
    private int maxr;
    private Alue[] alueet;
    private boolean kerrosLapi;
    private Hirvio[] hirviot;
    private int pisteet;
    private boolean kuollut;

    public Peli() {
        Luolageneraattori lg = new Luolageneraattori();
        this.lg = lg;
        this.pelaaja = new Pelaaja();
        this.portaat = new Portaat();
        this.r = new Satunnainen(10);
        this.pisteet = 0;
        this.kuollut = false;
        this.hirviot = null;
    }

    public Kerros annaUusiKerros() {
        this.kerrosLapi = false;
        this.kuollut = false;
        this.hirviot = null;

        //randomoi koko ja jakaumat tässä
        int rkoko = r.uusiInt(9) + 1;
        int jakaumat = r.uusiInt(4) + 1;
        //jakaumien maara ei saa olla isompi tai yhtä suuri kuin rokoko
        //Tai, saa, mutta voi johtaa kaatumisiin
        if (jakaumat >= rkoko) {
            jakaumat = rkoko - 1;
            if (rkoko == 1) {
                jakaumat = 1;
            }
        }
        Kerros kerros = this.lg.luoKerros(jakaumat, rkoko * 10);
        this.kerros = kerros;

        //napataan max luku jolla voi arpoa
        //sekä napataan alimmat alueet arpomista varten
        maxr = kerros.getAluePuu().montaSolmuaTasolla(jakaumat);
        this.alueet = this.kerros.getAlimmatAlueet();

        //Arvotaan:
        //-Pelaajan paikka
        arvoSijainti(this.pelaaja);
        //-Uloskaynnin paikka
        arvoSijainti(this.portaat);
        //-Hirvioiden maarat ja paikat
        if (maxr - 2 >= 0) {
            int hmaara = maxr;
            this.hirviot = new Hirvio[hmaara];
            for (int i = 0; i < hmaara; i++) {
                Hirvio hirvio = new Hirvio();
                arvoSijainti(hirvio);
                this.hirviot[i] = hirvio;
            }
        }
        //tulostaAlueet(kerros.getRuudukko());
        return kerros;
    }

    private void arvoSijainti(Liikutettava kohde) {
        //Arvotaan alue, liikutetaan valittu alue listan
        //loppuun korvaten sen alkuperäinen paikka listan lopulla 
        //ja vähennetään max arpomislukua.
        int a = r.uusiInt(this.maxr);
        int id = this.alueet[a].getId();
        Alue alue = this.alueet[a];
        this.alueet[a] = this.alueet[maxr - 1];
        this.alueet[maxr - 1] = alue;
        this.maxr--;

        Ruutu ruutu = this.kerros.annaSijaintiAlueesta(id);
        kohde.asetaSijainti(ruutu.getX(), ruutu.getY());

    }

    public void liikuta(Suunnat suunta, Liikutettava l) {
        if (suunta == Suunnat.ALAS) {
            if (voikoLiikkua(l.getX(), l.getY() + 1)) {
                l.liikutaAlas();
            }
        }
        if (suunta == Suunnat.OIKEA) {
            if (voikoLiikkua(l.getX() + 1, l.getY())) {
                l.liikutaOikealle();
            }
        }
        if (suunta == Suunnat.VASEN) {
            if (voikoLiikkua(l.getX() - 1, l.getY())) {
                l.liikutaVasemmalle();
            }
        }
        if (suunta == Suunnat.YLOS) {
            if (voikoLiikkua(l.getX(), l.getY() - 1)) {
                l.liikutaYlos();
            }
        }
        if (this.pelaaja.getX() == this.portaat.getX() & this.pelaaja.getY() == this.portaat.getY()) {
            this.kerrosLapi = true;
        }
    }

    private boolean voikoLiikkua(int x, int y) {
        int koko = this.kerros.getRuudukko().getKoko();
        if (x >= koko | y >= koko) {
            return false;
        }
        if (x < 0 | y < 0) {
            return false;
        }
        return this.kerros.getRuudukko().getRuutu(x, y).getArvo() > 0;
    }

    public Liikutettava[] getLiikutettavat() {
        int h = 0;
        if (this.hirviot != null) {
            h = this.hirviot.length;
        }
        Liikutettava[] l = new Liikutettava[2 + h];
        l[0] = this.pelaaja;
        l[1] = this.portaat;
        for (int i = 2; i < h + 2; i++) {
            l[i] = this.hirviot[i - 2];
        }
        return l;
    }

    public void paivitaHirviot() {
        if (this.hirviot != null) {
            for (int i = 0; i < this.hirviot.length; i++) {
                saikoHirvioPelaajan(this.hirviot[i]);
                int x = this.pelaaja.getX();
                int y = this.pelaaja.getY();
                boolean a = this.hirviot[i].nakeeko(this.kerros.getRuudukko(), x, y);
                if (a) {
                    this.hirviot[i].halytys();
                }
                if (this.hirviot[i].liikkuuko()) {
                    Suunnat suunta = this.hirviot[i].annaLiike(this.kerros.getRuudukko());
                    liikuta(suunta, this.hirviot[i]);
                }
                saikoHirvioPelaajan(this.hirviot[i]);
            }
        }
    }

    public void saikoHirvioPelaajan(Hirvio h) {
        if (h.getX() == this.pelaaja.getX() & h.getY() == this.pelaaja.getY()) {
            this.kuollut = true;
        }
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public boolean isKerrosLapi() {
        return kerrosLapi;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void setPisteet(int p) {
        this.pisteet = p;
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
            System.out.println("");
            for (int x = 0; x < k; x++) {
                if (level.getRuutu(x, y).getArvo() >= 1) {
                    System.out.print(level.getRuutu(x, y).getAlue());
                    if (level.getRuutu(x, y).getAlue() < 10) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
        }
        System.out.println("\n---------------------------------------");
        System.out.println("");
    }

    public boolean pelaajaKuoli() {
        return this.kuollut;
    }

}
