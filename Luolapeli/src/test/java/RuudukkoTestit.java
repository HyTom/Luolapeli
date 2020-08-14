/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logiikka.Ruudukko.Ruudukko;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author htommi
 */
public class RuudukkoTestit {
    
    @Test
    public void ruudukkoToimiiOikein() {
        Ruudukko r = new Ruudukko(5);
        assertEquals(r.getKoko(), 5);
    }
    
    @Test
    public void ruudukkoonVoiLisata() {
        Ruudukko r = new Ruudukko(5);
        assertEquals(r.ruutuIsEmpty(0, 0), false);
        r.lisaaRuutu(0, 0, 1);
        assertEquals(1, r.getRuutu(0, 0).getArvo());
    }
    
    @Test
    public void ruudukonAleuitaVoiMuuttaa() {
        Ruudukko r = new Ruudukko(5);
        r.setRuudunAlue(0, 0, 5);
        assertEquals(r.getRuutu(0, 0).getAlue(), 5);
    }
}
