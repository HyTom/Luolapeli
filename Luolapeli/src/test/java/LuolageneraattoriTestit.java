/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logiikka.Generointi.Kerros;
import Logiikka.Generointi.Luolageneraattori;
import Logiikka.Ruudukko.Ruudukko;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author htommi
 */
public class LuolageneraattoriTestit {
    
    public LuolageneraattoriTestit() {
    }
    
    @Test
    public void luoKerrosOlion() {
        Luolageneraattori lg = new Luolageneraattori();
        Ruudukko r = lg.luoKerros(1, 1).getRuudukko();
        Kerros kerros = new Kerros(0,0);
        assertEquals(kerros.getClass(), lg.luoKerros(0, 0).getClass());
    }
    
    @Test
    public void onkoLuotuKerrosJaettuOikein() {
        Luolageneraattori lg = new Luolageneraattori();
        Kerros k = lg.luoKerros(1, 2);
        Ruudukko r = k.getRuudukko();
        assertEquals(r.getRuutu(0, 0).getAlue(), 1);
        if (r.getRuutu(1, 0).getAlue() == 2) {
            assertEquals(r.getRuutu(1, 0).getAlue(), 2);
        } else {
            assertEquals(r.getRuutu(0, 1).getAlue(), 2);
        }
    }

}
