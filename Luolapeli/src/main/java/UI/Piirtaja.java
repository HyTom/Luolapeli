package UI;

import Logiikka.Generointi.Kerros;
import Logiikka.Generointi.Luolageneraattori;
import Logiikka.Ruudukko.Ruutu;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Piirtaja extends Canvas {

    private Kerros kerros;

    @Override
    public void paint(Graphics g) {
        //g.drawString("Hello", 40, 40);
        for (int y = 0; y < kerros.getRuudukko().getKoko(); y++) {
            for (int x = 0; x < kerros.getRuudukko().getKoko(); x++) {
                Ruutu r = kerros.getRuudukko().getRuutu(x, y);
                g.setColor(Color.black);
                if (r.getArvo() > 0) {
                    g.setColor(Color.GRAY);
                }
                g.fill3DRect(x * 10, y * 10, 10, 10, true);
                
                
            }
        }
    }

    void annaKerros(Kerros kerros) {
        this.kerros = kerros;
    }

}
