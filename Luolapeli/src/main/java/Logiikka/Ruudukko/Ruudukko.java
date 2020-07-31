package Logiikka.Ruudukko;

/**
 * 2D kartta
 * @author htommi
 */

public class Ruudukko {
    
    private Ruutu[][] ruudukko;
    private int[][] tyhja;
    private int koko;

    public Ruudukko(int n) {
        this.ruudukko = new Ruutu[n][n];
        this.tyhja = new int[n][n];
        this.koko = n;
    }
    
    /**
     * Luo uuden Ruutu olion ja lisää sen taulukkoon paikkaan x,y.
     * @param x Sijainti vaakarivillä.
     * @param y Sijainti pystyrivillä.
     * @param arvo Ruudun arvo.
     */
    public void lisaaRuutu(int x, int y, int arvo) {
        this.tyhja[x][y] = 1;
        Ruutu ruutu = new Ruutu(arvo);
    }
    
    /**
     * Palauttaa onko ruudukon ruutu kohdassa x, y tyhjä.
     * @param x Sijainti vaakarivillä.
     * @param y Sijainti pystyrivillä.
     * @return 
     */
    public boolean ruutuIsEmpty(int x, int y) {
        if (this.tyhja[x][y] == 0) {
            return true;
        }
        return false;
    }
    
    public Ruutu getRuutu(int x, int y) {
        return this.ruudukko[x][y];
    }

    public int getKoko() {
        return koko;
    }
    
}
