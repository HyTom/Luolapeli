/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void onkoLuotuKerrosJaettuOikein() {
        Luolageneraattori lg = new Luolageneraattori();
        Ruudukko r = lg.luoKerros(1, 1, 10);
        assertEquals(true, r.ruutuIsEmpty(0, 1));
        assertEquals(false, r.ruutuIsEmpty(1, 1));
    }

}
