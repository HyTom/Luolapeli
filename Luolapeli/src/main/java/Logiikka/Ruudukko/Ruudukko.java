package Logiikka.Ruudukko;

/**
 * 2D kartta joka pitää sisällään Ruutu olioita jotka tietävät oman sisältönsä.
 * @author htommi
 */

public class Ruudukko {
    
    private Ruutu[][] ruudukko;
    private int[][] tyhja;
    private int koko;

    /**
     * Ruudukko pitää yllä tietoa jokaisesta ruudusta luolapelin kerroksessa.
     * Ruutu oliot on luotu valmiiksi.
     * @param n ruudukon koko
     */
    public Ruudukko(int n) {
        this.ruudukko = new Ruutu[n][n];
        this.tyhja = new int[n][n];
        this.koko = n;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                lisaaRuutu(x, y, 0);
            }
        }
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
        this.ruudukko[x][y] = ruutu;
    }
    
    /**
     * Palauttaa onko ruudukon ruutu kohdassa x, y tyhjä.
     * @param x Sijainti vaakarivillä.
     * @param y Sijainti pystyrivillä.
     * @return 
     */
    public boolean ruutuIsEmpty(int x, int y) {
        return this.tyhja[x][y] <= 0;
    }
    
    public Ruutu getRuutu(int x, int y) {
        return this.ruudukko[x][y];
    }

    public int getKoko() {
        return koko;
    }

    public void setRuudunAlue(int x, int y, int alue) {
        this.ruudukko[x][y].setAlue(alue);
    }
    
    public void setRuudunArvo(int x, int y, int arvo) {
        this.ruudukko[x][y].setArvo(arvo);
    }
    
}
