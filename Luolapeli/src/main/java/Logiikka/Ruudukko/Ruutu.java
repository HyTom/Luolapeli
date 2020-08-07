
package Logiikka.Ruudukko;

public class Ruutu {
    private int arvo;
    private int alue;
    
    public Ruutu(int i) {
        this.arvo = i;
        this.alue = 0;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    void setAlue(int alue) {
        this.alue = alue;
    }

    public int getAlue() {
        return alue;
    }
    
}
