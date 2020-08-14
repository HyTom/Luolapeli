package Logiikka.Generointi;

public class Alue {

    private int id;
    private int x;
    private int y;
    private int pituusx;
    private int pituusy;
    private int koko;
    private int[][] huone;

    /**
     * * Alue on palanen luolapelin kerrosta. Se sisältää tiedon huoneesta
     * jonka se sisältää sekä sillä on jokin id.
     *
     * @param id tunniste
     * @param x sijainnin x kordinaatti
     * @param y sijainnin Y kordinaatti
     * @param koko kuinka monta ruutua alue jatkuu alas ja oikealle
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

}
