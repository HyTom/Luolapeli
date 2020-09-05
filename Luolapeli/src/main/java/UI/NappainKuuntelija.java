package UI;

import Logiikka.Pelilogiikka.Suunnat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NappainKuuntelija extends KeyAdapter {

    private PeliSovellus ps;

    NappainKuuntelija(PeliSovellus ps) {
        this.ps = ps;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int nappain = e.getKeyCode();
        if (nappain == e.VK_U) {
            ps.aloitaUusiKerros();
        }
        if (nappain == e.VK_DOWN) {
            ps.pelaajaLiikkui(Suunnat.ALAS);
        }
        if (nappain == e.VK_RIGHT) {
            ps.pelaajaLiikkui(Suunnat.OIKEA);
        }
        if (nappain == e.VK_LEFT) {
            ps.pelaajaLiikkui(Suunnat.VASEN);
        }
        if (nappain == e.VK_UP) {
            ps.pelaajaLiikkui(Suunnat.YLOS);
        }
        ps.alkaakoUusiKierros();
    }

}
