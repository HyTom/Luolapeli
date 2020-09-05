package Logiikka.Pelilogiikka;

import Logiikka.Generointi.Satunnainen;
import Logiikka.Ruudukko.Ruudukko;
import java.awt.Color;

public class Hirvio extends Liikutettava {

    private int halytys = 0;
    private int paikallaan = 0;
    private int viimex = 0;
    private int viimey = 0;
    private Suunnat[] liikkeet;

    public Hirvio() {
        super(0, 0, Color.pink);
        this.liikkeet = null;
    }

    /**
     * Tarkistaa näkeekö hirvio pelaajan. Hirvio nakee 8 suuntaan.
     *
     * @param x pelaajan sijainti x
     * @param y pelaajan sijainti y
     * @return Näkikö
     */
    public boolean nakeeko(Ruudukko ruudukko, int x, int y) {
        boolean nakiko = katsoSuunnat(ruudukko, x, y);
        if (nakiko) {
            this.viimex = x;
            this.viimey = y;
        }
        if (this.halytys > 0 & this.halytys < 5) {
            halytys++;
        }
        return nakiko;
    }

    private boolean katsoSuunnat(Ruudukko ruudukko, int x, int y) {
        //ylos
        if (katso(ruudukko, 0, -1, x, y)) {
            return true;
        }
        //alas
        if (katso(ruudukko, 0, 1, x, y)) {
            return true;
        }
        //vasen
        if (katso(ruudukko, -1, 0, x, y)) {
            return true;
        }
        //oikea
        if (katso(ruudukko, 1, 0, x, y)) {
            return true;
        }
        //ylosvasen
        if (katso(ruudukko, -1, -1, x, y)) {
            return true;
        }
        //ylosoikea
        if (katso(ruudukko, 1, -1, x, y)) {
            return true;
        }
        //alasoikea
        if (katso(ruudukko, 1, 1, x, y)) {
            return true;
        }
        //alasvasen
        if (katso(ruudukko, -1, 1, x, y)) {
            return true;
        }

        return false;
    }

    private boolean katso(Ruudukko r, int x, int y, int px, int py) {
        if (!voikoKatsoa(r, x, y)) {
            return false;
        }
        if (this.getX() + x == px & this.getY() + y == py) {
            return true;
        }
        if (x < 0) {
            x--;
        }
        if (x > 0) {
            x++;
        }
        if (y < 0) {
            y--;
        }
        if (y > 0) {
            y++;
        }
        return katso(r, x, y, px, py);
    }

    private boolean voikoKatsoa(Ruudukko r, int x, int y) {
        int koko = r.getKoko();
        if (this.getX() + x >= koko | this.getY() + y >= koko) {
            return false;
        }
        if (this.getX() + x < 0 | this.getY() + y < 0) {
            return false;
        }
        return r.getRuutu(this.getX() + x, this.getY() + y).getArvo() > 0;
    }

    void halytys() {
        if (this.halytys == 0) {
            this.halytys = 1;
            this.paikallaan = 0;
            this.setVari(Color.RED.darker());
        }
        if (this.halytys == 5) {
            this.paikallaan = 0;
        }
    }

    public boolean liikkuuko() {
        if (this.halytys == 5) {
            return true;
        }
        return false;
    }

    public Suunnat annaLiike(Ruudukko ruudukko) {
        Satunnainen s = new Satunnainen(2);
        if (this.viimey < this.getY() & this.viimex < this.getX()) {
            if (s.uusiInt() == 1) {
                return Suunnat.YLOS;
            } else {
                return Suunnat.VASEN;
            }
        }
        if (this.viimey < this.getY() & this.viimex > this.getX()) {
            if (s.uusiInt() == 1) {
                return Suunnat.YLOS;
            } else {
                return Suunnat.OIKEA;
            }
        }
        if (this.viimey > this.getY() & this.viimex < this.getX()) {
            if (s.uusiInt() == 1) {
                return Suunnat.ALAS;
            } else {
                return Suunnat.VASEN;
            }
        }
        if (this.viimey > this.getY() & this.viimex > this.getX()) {
            if (s.uusiInt() == 1) {
                return Suunnat.ALAS;
            } else {
                return Suunnat.OIKEA;
            }
        }
        if (this.viimey < this.getY()) {
            return Suunnat.YLOS;
        }
        if (this.viimey > this.getY()) {
            return Suunnat.ALAS;
        }
        if (this.viimex < this.getX()) {
            return Suunnat.VASEN;
        }
        if (this.viimex > this.getX()) {
            return Suunnat.OIKEA;
        }
        this.paikallaan++;
        if (this.paikallaan >= 5) {
            this.halytys = 0;
            this.paikallaan = 0;
            this.setVari(Color.pink);
        }
        return Suunnat.PAIKALLAAN;
    }

    /**
     * Antaa vain tilan piirtajalle mita piirtaa extrana
     *
     * @return tila
     */
    public int annaTila() {
        if (this.halytys == 0) {
            return 1;
        }
        if (this.halytys > 0) {
            if (this.halytys < 5) {
                return 2;
            }
            if (this.paikallaan == 0) {
                return 3;
            }
        }
        return 4;
    }

}
