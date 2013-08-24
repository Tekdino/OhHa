package laivanupotus;
import java.util.Scanner;


public class Laivanupotus {
    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        //Rakennellaan peli
        int leveys = kysyLuku("Kartan leveys ruutuina?");
        int korkeus = kysyLuku("Kartan korkeus ruutuina?");
        
        Kartta kartta = new Kartta(leveys, korkeus);
    }
    
    /**
     * Kysyy luvun ja tarkistaa että kyseessä on luku
     * @param kysymys Lause joka näytetään käyttäjälle
     * @return palauttaa tarkistetun luvun 
     */
    public static int kysyLuku(String kysymys) {
        System.out.println(kysymys);
        int luku = lukija.nextInt();
        return luku;
        // TODO Tähän virheenkäsittely, poikkeukset ja loop kunnes kunnollinen
        // luku on annettu
    }
}
