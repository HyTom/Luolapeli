/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Logiikka.Generointi.AluePuu;

/**
 *
 * @author htommi
 */
public class AluePuuTestit {
    
    public AluePuuTestit() {
    }
    
    @Test
    public void antaakoOikeinMontaSolmuaTasolla1() {
        AluePuu puu = new AluePuu(0, 1);
        int i = puu.montaSolmuaTasolla(0);
        assertEquals(i, 1);
    }
    
    
    @Test
    public void antaakoOikeinMontaSolmuaTasolla2() {
        AluePuu puu = new AluePuu(0, 1);
        int i = puu.montaSolmuaTasolla(1);
        assertEquals(i, 2);
    }
    
    
    @Test
    public void antaakoOikeinMontaSolmuaTasolla3() {
        AluePuu puu = new AluePuu(0, 1);
        int i = puu.montaSolmuaTasolla(2);
        assertEquals(i, 4);
    }
    
     @Test
    public void antaakoOikeinMontaSolmuaTasolla4() {
        AluePuu puu = new AluePuu(0, 1);
        int i = puu.montaSolmuaTasolla(2);
        assertEquals(i, 8);
    }
}
