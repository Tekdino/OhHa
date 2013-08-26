package laivanupotus;
import java.util.Scanner;

/**
 * Pelin komentoriviversio
 */
public class Laivanupotus {
    public static Scanner lukija = new Scanner(System.in);

    public static void  pelaa() {
        //Rakennellaan peli
        int leveys = kysyLuku("Kartan leveys ruutuina?");
        int korkeus = kysyLuku("Kartan korkeus ruutuina?");
        
        Kartta kartta = new Kartta(leveys, korkeus);
        Ampuja ampuja = new Ampuja(kartta);
        Laskuri laskuri = new Laskuri(kartta);
        Laivaaja laivaaja = new Laivaaja(laskuri);
        kartta.visualisoi();
        
        //Lisätään laivat
        int maara = kysyLuku("Montako laivaa lisätään?");
        boolean onnistuu;
        boolean sopii;
        int tyyppi;
        int asento;
        int sarake;
        int rivi;
        
        for (int i=0; i<maara; i++) {
            do {
        tyyppi = kysyLuku("Laivan " + (i+1) + "/" + maara + " pituus?");
        asento = kysyLuku("Laivan asento? 1=vaaka, 2=pysty");
        if (asento == 1) {
            sarake = kysyLuku("Laivan vasemmanpuoleisimman ruudun sarakekoordinaatti?");
            rivi = kysyLuku("Mille riville laiva tulee?");
        }
        else if (asento == 2) {
            sarake = kysyLuku("Mihin sarakkeeseen laiva tulee?");
            rivi = kysyLuku("Laivan ylimmän ruudun rivikoordinaatti?");
        }
        else {
            System.out.println("Koska annettu asento oli jotain muuta kuin 1 tai 2, asennoksi otetaan vaaka!");
            asento = 1;
            sarake = kysyLuku("Laivan vasemmanpuoleisimman ruudun sarakekoordinaatti?");
            rivi = kysyLuku("Mille riville laiva tulee?");
        }
        sopii = laivaaja.tunnusteleTilaus(tyyppi, rivi-1, sarake-1, asento); //sopiiko laiva näin
        if (sopii == false) { System.out.println("Laiva ei mahdu näin! Kokeile uudestaan"); }
            } while (sopii==false);
            
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
                int y;
                do {
                y = kysyLuku("Ammuksen sarakekoordinaatti?");
                if (y> kartta.sarakkeet) { System.out.println("Sarakkeita on vain " + kartta.sarakkeet + "!"); }
                } while (y > kartta.sarakkeet);
                int z;
                do {
                z = kysyLuku("Ammuksen rivikoordinaatti?");
                if (z > kartta.rivit) { System.out.println("Rivejä on vain " + kartta.rivit + "!"); }
                } while (z > kartta.rivit);
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
                    
                    if (laskuri.omatRuudut <=0) { //vastustaja upottaa vikan laivan
                        break;
                    }
                } 
                while (sensori2 == true);
                }
                
                kartta.visualisoi();
                laskuri.pelivuoro = true;
            }
            
        } while (laskuri.vihunRuudut > 0);
        
        //jompikumpi osapuoli hävinnyt
        
        kartta.visualisoi();
        System.out.println("Loppu");
        
    }
    
    
    //TYÖKALUMETODIT
    
    
    /**
     * Kysyy luvun ja tarkistaa että kyseessä on luku
     * @param kysymys Lause joka näytetään käyttäjälle
     * @return palauttaa tarkistetun luvun 
     */
    public static int kysyLuku(String kysymys) {
        System.out.println(kysymys);
        boolean toimii = true;
        int luku =-1;
        
        do {
        
        String vastaus = lukija.nextLine();
        
        try {
            vastaus = vastaus.trim(); //karsii mahdolliset välilyönnit
            luku = Integer.parseInt(vastaus);
            if (luku>0) {
                toimii = true;
                return luku;
            }
            else if (luku<=0) {
                toimii = false;
                System.out.println("Luvun on oltava suurempi kuin nolla! " + kysymys);
            }
        }
        
        catch (NumberFormatException e) {
            System.out.println("Käytä vain numeroita! " + kysymys);
            toimii = false;
        }
    } while (!toimii);
        return luku;
    }
}
