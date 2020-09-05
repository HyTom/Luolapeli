package UI;

import Logiikka.Generointi.Kerros;
import Logiikka.Generointi.Luolageneraattori;
import Logiikka.Pelilogiikka.Peli;
import Logiikka.Pelilogiikka.Suunnat;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PeliSovellus extends JFrame {

    private final Piirtaja piirtaja;
    static JFrame f;
    private final Peli peli;
    private final NappainKuuntelija nk;
    private boolean eka;

    public PeliSovellus(Peli peli) {
        this.piirtaja = new Piirtaja();
        this.peli = peli;
        this.nk = new NappainKuuntelija(this);
        eka = true;
    }

    public void aloita() {
        aloitaUusiKerros();
        f = new JFrame("Luolapeli - Pisteet: 0");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setFocusable(true);
        Dimension d = new Dimension(600, 600);
        f.setMinimumSize(d);

        f.addKeyListener(this.nk);

        f.add(this.piirtaja);

        f.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component) e.getSource();
                Piirtaja piirtaja = (Piirtaja) f.getContentPane().getComponent(0);
                piirtaja.annaIkkunanKoko(f.getWidth(), f.getHeight() - f.getInsets().top);

            }
        });

        f.pack();
        f.setVisible(true);
        this.piirtaja.annaIkkunanKoko(d.width, d.height - f.getInsets().top);
    }

    public void aloitaUusiKerros() {
        if (this.eka) {
            this.eka = false;
        } else {
            if (this.peli.isKerrosLapi()) {
                this.peli.setPisteet(this.peli.getPisteet() + 1);
            }
            f.setTitle("Luolapeli - Pisteet: " + this.peli.getPisteet());
        }
        Kerros kerros = peli.annaUusiKerros();
        this.piirtaja.setKerros(kerros);
        this.piirtaja.setLiikutettavat(peli.getLiikutettavat());
        this.piirtaja.repaint();
    }

    void pelaajaLiikkui(Suunnat suunta) {
        this.peli.liikuta(suunta, this.peli.getPelaaja());
        this.peli.paivitaHirviot();
        this.piirtaja.repaint();
    }

    public void alkaakoUusiKierros() {
        if (this.peli.isKerrosLapi()) {
            aloitaUusiKerros();
        } else if (this.peli.pelaajaKuoli()) {
            aloitaUusiKerros();
        }
    }

}
