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
    public void antaakoOikeinMontaSolmuaTasolla0() {
        AluePuu puu = new AluePuu(10, 0);
        int i = puu.montaSolmuaTasolla(0);
        assertEquals(i, 1);
    }
    
    
    @Test
    public void antaakoOikeinMontaSolmuaTasolla1() {
        AluePuu puu = new AluePuu(10, 1);
        int i = puu.montaSolmuaTasolla(1);
        assertEquals(i, 2);
    }
    
    
    @Test
    public void antaakoOikeinMontaSolmuaTasolla2() {
        AluePuu puu = new AluePuu(10, 2);
        int i = puu.montaSolmuaTasolla(2);
        assertEquals(i, 4);
    }
    
     @Test
    public void antaakoOikeinMontaSolmuaTasolla3() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.montaSolmuaTasolla(3);
        assertEquals(i, 8);
    }
    
    @Test
    public void antaakoOikeinMistaIndexAlkaa0() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(0);
        assertEquals(i, 0);
    }
    
    public void antaakoOikeinMistaIndexAlkaa1() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(0);
        assertEquals(i, 0);
    }
    
    public void antaakoOikeinMistaIndexAlkaa2() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(1);
        assertEquals(i, 1);
    }
    
    public void antaakoOikeinMistaIndexAlkaa3() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(2);
        assertEquals(i, 3);
    }
    
    public void antaakoOikeinMistaIndexAlkaa4() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(4);
        assertEquals(i, 7);
    }
    
    
    public void antaakoOikeinMistaIndexAlkaa5() {
        AluePuu puu = new AluePuu(10, 3);
        int i = puu.indexMistaAlkaaTaso(5);
        assertEquals(i, 15);
    }
}
