package laivanupotus;
import java.util.Scanner;


public class Laivanupotus {
    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        //Rakennellaan peli
        int leveys = kysyLuku("Kartan leveys ruutuina?");
        int korkeus = kysyLuku("Kartan korkeus ruutuina?");
        
        Kartta kartta = new Kartta(leveys, korkeus);
        Ampuja ampuja = new Ampuja(kartta);
        Laskuri laskuri = new Laskuri(kartta);
        Laivaaja laivaaja = new Laivaaja(laskuri);
        
        //Lisätään laivat
        int maara = kysyLuku("Montako laivaa lisätään?");
        boolean onnistuu;
        
        for (int i=0; i<maara; i++) {
        int tyyppi = kysyLuku("Laivan " + (i+1) + "/" + maara + " pituus?");
        int asento = kysyLuku("Laivan asento? 1=vaaka, 2=pysty");
        int sarake = kysyLuku("Laivan vasemmanpuoleisimman/ylimmän ruudun sarakekoordinaatti?");
        int rivi = kysyLuku("Laivan vasemmanpuoleisimman/ylimmän ruudun rivikoordinaatti?");
        laivaaja.laivaa(tyyppi, rivi-1, sarake-1, asento, true);
        //Arpoo samalla vastustajalle saman kokoisen laivan
        do {
        laivaaja.arvoRuutu();
        onnistuu = laivaaja.tunnusteleLaiva(tyyppi, laivaaja.vapaaY, laivaaja.vapaaX);
        } while (onnistuu == false);
        laivaaja.laivaa(tyyppi, laivaaja.vapaaY, laivaaja.vapaaX, asento, false);
        kartta.visualisoi();
        }
        
        // TODO Selvitä miks lisää ylimääräsiä laivoja omalle puolelle
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
