
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

    public void setArvo(int a) {
        this.arvo = a;
    }

    void setAlue(int a) {
        this.alue = a;
    }

    public int getAlue() {
        return alue;
    }
    
}
