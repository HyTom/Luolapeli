package UI;

import Logiikka.Generointi.Kerros;
import Logiikka.Pelilogiikka.Hirvio;
import Logiikka.Pelilogiikka.Liikutettava;
import Logiikka.Ruudukko.Ruutu;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Piirtaja extends Canvas {

    private Kerros kerros;
    private Liikutettava[] liikkuvat;
    private int ileveys;
    private int ikorkeus;

    @Override
    public void paint(Graphics g) {
        //g.drawString("Hello", 40, 40);
        piirraRuudukko(g);
        piirraLiikutettavat(g);

    }

    void setKerros(Kerros kerros) {
        this.kerros = kerros;
    }

    void setLiikutettavat(Liikutettava[] liikkuvat) {
        this.liikkuvat = liikkuvat;
    }

    private void piirraRuudukko(Graphics g) {
        int koko = this.kerros.getRuudukko().getKoko();
        int leveys = this.ileveys / koko;
        int korkeus = this.ikorkeus / koko;
        g.setColor(Color.black);
        g.fillRect(0, 0, this.ileveys, this.ileveys);
        for (int y = 0; y < kerros.getRuudukko().getKoko(); y++) {
            for (int x = 0; x < kerros.getRuudukko().getKoko(); x++) {
                Ruutu r = kerros.getRuudukko().getRuutu(x, y);
                g.setColor(Color.black);
                if (r.getArvo() > 0) {
                    g.setColor(Color.GRAY);
                }
                g.fill3DRect(x * leveys, y * korkeus, leveys, korkeus, true);

            }
        }
    }

    private void piirraLiikutettavat(Graphics g) {
        int koko = this.kerros.getRuudukko().getKoko();
        int leveys = this.ileveys / koko;
        int tl = leveys / 5;
        int korkeus = this.ikorkeus / koko;
        int tk = korkeus / 5;
        for (int i = 0; i < this.liikkuvat.length; i++) {
            Color c = liikkuvat[i].getVari();
            g.setColor(c);
            g.fill3DRect(liikkuvat[i].getX() * leveys + tl, liikkuvat[i].getY() * korkeus + tk, leveys - tl * 2, korkeus - tk * 2, false);
            if (liikkuvat[i].getClass() == Hirvio.class) {
                Hirvio h = (Hirvio) liikkuvat[i];
                g.setColor(Color.RED);
                if (h.annaTila() == 2) {
                    g.setColor(Color.RED);
                    g.drawString("!", liikkuvat[i].getX() * leveys + tl, liikkuvat[i].getY() * korkeus + tk);
                }
                if (h.annaTila() == 4) {
                    g.setColor(Color.RED);
                    g.drawString("??", liikkuvat[i].getX() * leveys + tl, liikkuvat[i].getY() * korkeus + tk);
                }
            }
        }
    }

    void annaIkkunanKoko(int leveys, int korkeus) {
        this.ileveys = leveys;
        this.ikorkeus = korkeus;
    }

}
