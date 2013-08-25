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
        laskuri.omatRuudut += tyyppi;
        laskuri.vihunRuudut += tyyppi;
        
        //Arpoo samalla vastustajalle saman kokoisen laivan
        do {
        laivaaja.arvoRuutu();
        onnistuu = laivaaja.tunnusteleLaiva(tyyppi, laivaaja.vapaaY, laivaaja.vapaaX);
        } while (onnistuu == false);
        kartta.visualisoi();
        }
        
        //Laivat on aseteltu, peli alkuun
        
        do {
            if (laskuri.pelivuoro == true) { //pelaajan pelivuoro
                int y = kysyLuku("Ammuksen sarakekoordinaatti?");
                int z = kysyLuku("Ammuksen rivikoordinaatti?");
                ampuja.ammu(z-1, y-1); //pelaaja ampuu
                
                if (kartta.vihuPuoli[z-1][y-1].laivatyyppi >0) { //osuma
                    kartta.visualisoi();
                    laskuri.vihunRuudut --;
                    System.out.println("Osuma! Ammu uudestaan");
                }
                
                else if (kartta.vihuPuoli[z-1][y-1].laivatyyppi == 0) { //huti
                    kartta.visualisoi();
                    System.out.println("Huti");
                    laskuri.seuraavaVuoro();
                }
                
            }
            
            if (laskuri.pelivuoro == false) { //vastustajan vuoro
                boolean sensori;
                boolean sensori2;
                sensori = ampuja.isku();
   
                if (sensori==true) { //osuu ekalla
                    laskuri.omatRuudut--;
                    
                    do {
                    sensori2 = ampuja.viereen(ampuja.ammuttuX,ampuja.ammuttuY); //vastustajan uusi yritys
                    
                                if (sensori2==true) { laskuri.omatRuudut--; } //osui taas
                                if (sensori2==false) { break; } //ampuu ohi
                    
                    if (laskuri.omatRuudut <=0) { //vastustaja upottaa vikan laivan
                        break;
                    }
                } 
                while (sensori2 == true);
                }
                else if (sensori==false) {
                    break;
                }
                
                kartta.visualisoi();
                laskuri.pelivuoro = true;
            }
            
        } while (laskuri.vihunRuudut > 0);
        
        //jompikumpi osapuoli hävinnyt
        
        kartta.visualisoi();
        System.out.println("Loppu");
        
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
