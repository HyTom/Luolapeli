package Logiikka.Generointi;

import Logiikka.Ruudukko.Ruutu;

public class Alue {

    private int id;
    private int x;
    private int y;
    private int pituusx;
    private int pituusy;
    private int koko;
    private int[][] huone;
    private boolean onkoPysty;

    /**
     * * Alue on palanen luolapelin kerrosta. Se sisältää tiedon huoneesta
     * jonka se sisältää sekä sillä on jokin id.
     *
     * @param id tunniste
     * @param x sijainnin x kordinaatti
     * @param y sijainnin Y kordinaatti
     * @param pituusx Pituus sivusuunnassa
     * @param pituusy Pituus pysysuunnassa
     * @param onkoPysty Onko leikattu pystysuunnassa
     */
    public Alue(int id, int x, int y, int pituusx, int pituusy) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.pituusx = pituusx;
        this.pituusy = pituusy;
        this.koko = pituusx * pituusy;
        if (pituusx == 0 | pituusy == 0) {
            huone = new int[1][1];
        } else {
            huone = new int[pituusx][pituusy];
        }
    }

    public boolean isOnkoPysty() {
        return onkoPysty;
    }

    public void setOnkoPysty(boolean onkoPysty) {
        this.onkoPysty = onkoPysty;
    }

    public int getId() {
        return id;
    }

    public int getKoko() {
        return koko;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPituusx() {
        return pituusx;
    }

    public int getPituusy() {
        return pituusy;
    }

    public int[][] getHuone() {
        return huone;
    }

    int onkoKohdassaHuonetta(int x, int y) {
        return huone[x][y];
    }

    Ruutu annaEkaTyhjaRuutu() {
        Ruutu ruutu = new Ruutu(1);
        for (int hy = 0; hy < this.pituusy; hy++) {
            for (int hx = 0; hx < this.pituusx; hx++) {
                if (this.huone[hx][hy] > 0) {
                    ruutu.setXjaY(hx + this.x, hy + this.y);
                    return ruutu;
                }
            }
        }
        return ruutu;
    }

}
