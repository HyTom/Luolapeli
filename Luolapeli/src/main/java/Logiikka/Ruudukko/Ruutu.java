package Logiikka.Ruudukko;

/**
 * Ruutu olio vastaa yhtä Luolapelin ruutua, johon voi (tai ei voi) liikkua ja
 * joka sisältää pelin objekteja.
 *
 * @author htommi
 */
public class Ruutu {

    private int arvo;
    private int alue;
    private int x;
    private int y;

    /**
     * Uusi Ruutu olio.
     *
     * @param i Ruudun arvo maarittaa voiko ruutuun liikkua. Jos arvo on 0, on
     * kyseessä seinä.
     */
    public Ruutu(int i) {
        this.arvo = i;
        this.alue = 0;
        x = 0;
        y = 0;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int a) {
        this.arvo = a;
    }

    void setAlue(int a) {
        this.alue = a;
    }

    public int getAlue() {
        return alue;
    }

    public void setXjaY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
