package Logiikka.Generointi;

/**
 * Luo satunnaisia lukuja
 */
public class Satunnainen {

    int edellinen;
    int max;

    public Satunnainen(int max) {
        uusiMax(max);
    }

    public void uusiMax(int max) {
        if (max != 0) {
            this.max = max;
            this.edellinen = (int) (System.currentTimeMillis() % max);
            uusiInt();
            uusiInt();
        }
    }

    public int uusiInt() {
        edellinen = (edellinen * 32719 + 3) % 32749;

        return edellinen % max;
    }

    public int uusiInt(int luku) {
        if (luku <= 0) {
            return 0;
        }
        uusiMax(luku);
        return uusiInt();
    }

}
