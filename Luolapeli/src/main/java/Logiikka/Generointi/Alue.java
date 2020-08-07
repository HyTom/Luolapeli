
package Logiikka.Generointi;

class Alue {
    private int id;
    private int x;
    private int y;
    private int pituusx;
    private int pituusy;
    private int koko;

    /**
     * * Alue on palanen luolapelin kerrosta.
     * Se sisältää tiedon huoneesta jonka se sisältää sekä sillä on jokin id.
     * @param id tunniste
     * @param x sijainnin x kordinaatti
     * @param y sijainnin Y kordinaatti
     * @param koko kuinka monta ruutua alue jatkuu alas ja oikealle
     */
    public Alue(int id, int x, int y, int pituusx, int pituusy) {
        this.id = id;
        this.x = x;
        this.y = y;
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
    
    
    
    
    
}
