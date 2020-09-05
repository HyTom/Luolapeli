/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logiikka.Generointi.Alue;
import Logiikka.Generointi.Huonegeneraattori;
import Logiikka.Generointi.Satunnainen;
import java.util.Random;
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
public class HuonegeneraattoriTestit {

    @Test
    public void metodiIsoinMahdollinenToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        hg.isoinMahdollinen(alue, huone);
        assertEquals(huone[0][0], 1);
        huone[0][0] = 0;
    }

    @Test
    public void metodiNelioToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.nelio(alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiPilareitaToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.pilareita(alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiRistikkoToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.ristikko(alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiTaysinRandomToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.taysinRandom(new Satunnainen(10), alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiTemppeliToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.temppeli(alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiYksinainenToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        hg.yksinainen(alue, huone);
        assertEquals(huone[0][0], 1);
    }

    @Test
    public void metodiYmpyraToimiiPienillaluvuilla() {
        Huonegeneraattori hg = new Huonegeneraattori();
        int[][] huone = new int[1][1];
        Alue alue = new Alue(1, 0, 0, 1, 1);
        huone[0][0] = 0;
        hg.ympyra(alue, huone);
        assertEquals(huone[0][0], 1);
    }

}
