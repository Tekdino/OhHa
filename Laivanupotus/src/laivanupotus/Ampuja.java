package laivanupotus;
import java.util.Random;

/**
 *Luokka sisältää koordinaatteihin ampumisessa tarvitun toiminnallisuuden
 */
public class Ampuja {
    Kartta kartta;
    
    /**
     * Konstruktorille annetaan parametrina käytettävä Kartta
     * @param peli luokan käyttämä Kartta halutuilla parametreilla
     */
    public Ampuja(Kartta peli) {
        kartta = peli;
    }
    
    /**
     * Ammutaan annettuihin koordinaatteihin
     * @param x vaaka
     * @param y pysty
     */
    public void ammu(int x, int y) {
        kartta.vihuPuoli[x][y].ammu();
    }
    
    /**
     * Ammutaan satunnaiseen kohtaan
     */
    public void isku() {
        Random arpoja = new Random();
        int x = arpoja.nextInt(kartta.rivit);
        int y = arpoja.nextInt(kartta.sarakkeet);
        kartta.omaPuoli[x][y].ammu();
    }
    
    /**
     * Ammutaan sopivaan kohtaan annettujen koordinaattien vieressä
     */
    public void viereen(int x, int y) {
        // TODO tähä jotai fiksuu ettei mee koskaa ruudukon ulkopuolelle
        // Arpoo yhen annettujen koordinaattien viereisist ruuduist ja ampuu
        // siihe jos siihen ei oo vielä ammuttu
    }
}
