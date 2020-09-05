package Logiikka.Pelilogiikka;

import java.awt.Color;

public class Liikutettava {

    private int x;
    private int y;
    private Color vari;

    public Liikutettava(int x, int y, Color vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    public void asetaSijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void liikutaYlos() {
        this.y--;
    }

    public void liikutaAlas() {
        this.y++;
    }

    public void liikutaVasemmalle() {
        this.x--;
    }

    public void liikutaOikealle() {
        this.x++;
    }

    public Color getVari() {
        return this.vari;
    }

    public void setVari(Color vari) {
        this.vari = vari;
    }
}
