/*
 * Laivanupotuspeli
 */
package laivanupotus;

/**
 *
 * @author Tekdino
 */
public class Laivanupotus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // karttatesti
        
        Kartta kartta = new Kartta(5,5);
        System.out.println("Toka:");
        kartta.visualisoi();
    }
}
