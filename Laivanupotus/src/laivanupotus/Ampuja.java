package laivanupotus;
import java.util.Random;

/**
 *Luokka sisältää koordinaatteihin ampumisessa tarvitun toiminnallisuuden
 */
public class Ampuja {
    Kartta kartta = new Kartta();
    
    public Ampuja() {
        
    }
    
    /**
     * Ammutaan annettuihin koordinaatteihin
     * @param x vaaka
     * @param y pysty
     */
    public void Ammu(int x, int y) {
        kartta.vihuPuoli[x][y].ammu();
    }
    
    /**
     * Ammutaan satunnaiseen kohtaan
     */
    public void Isku() {
        Random arpoja = new Random();
        int x = arpoja.nextInt(kartta.rivit);
        int y = arpoja.nextInt(kartta.sarakkeet);
        kartta.omaPuoli[x][y].ammu();
    }
    
    /**
     * Ammutaan sopivaan kohtaan annettujen koordinaattien vieressä
     */
    public void Viereen(int x, int y) {
        // TODO tää
    }
}
