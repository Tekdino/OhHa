package laivanupotus;
import java.awt.Component;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Pelin komentoriviversio
 */
public class Laivanupotus {
    public static Scanner lukija = new Scanner(System.in);
    private static Component frame;
    
    public static void  pelaa() {
        //Rakennellaan peli
        GUI.ilmoitus.setText("Rakennellaan kartta");
        int leveys = kysyLuku("Kartan leveys ruutuina?");
        int korkeus = kysyLuku("Kartan korkeus ruutuina?");
        
        Kartta kartta = new Kartta(leveys, korkeus);
        Ampuja ampuja = new Ampuja(kartta);
        Laskuri laskuri = new Laskuri(kartta);
        Laivaaja laivaaja = new Laivaaja(laskuri);
        kartta.visualisoi();
        
        //Lisätään laivat
        GUI.ilmoitus.setText("Lisäillään laivat");
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
            GUI.ilmoitus.setText("Koska annettu asento oli jotain muuta kuin 1 tai 2, asennoksi otetaan vaaka!");
            asento = 1;
            sarake = kysyLuku("Laivan vasemmanpuoleisimman ruudun sarakekoordinaatti?");
            rivi = kysyLuku("Mille riville laiva tulee?");
        }
        sopii = laivaaja.tunnusteleTilaus(tyyppi, rivi-1, sarake-1, asento); //sopiiko laiva näin
        if (sopii == false) { JOptionPane.showMessageDialog(frame, "Laiva ei mahdu näin! Kokeile uudestaan"); }
            } while (sopii==false);
            
        laivaaja.laivaa(tyyppi, rivi-1, sarake-1, asento, true);
        
        //Arpoo samalla vastustajalle saman kokoisen laivan
        do {
        laivaaja.arvoRuutu();
        onnistuu = laivaaja.tunnusteleLaiva(tyyppi, laivaaja.vapaaY, laivaaja.vapaaX);
        } while (onnistuu == false);
        laivaaja.laivaa(tyyppi, laivaaja.vapaaY, laivaaja.vapaaX, laivaaja.tsekattuAsento, false);
        kartta.visualisoi();
        }
        
        //Lasketaan laivat
        
        for (int q=0; q<kartta.vihuPuoli.length; q++) {
            for (int w=0; w<kartta.vihuPuoli[q].length; w++) {
                if (kartta.vihuPuoli[q][w].laivatyyppi>0) {
                    laskuri.vihunRuudut++;
                }
            }
        }
        
        for (int q=0; q<kartta.omaPuoli.length; q++) {
            for (int w=0; w<kartta.omaPuoli[q].length; w++) {
                if (kartta.omaPuoli[q][w].laivatyyppi>0) {
                    laskuri.omatRuudut++;
                }
            }
        }
        
        GUI.ilmoitus.setText("Kohteita " + laskuri.vihunRuudut);
        //Laivat on aseteltu, peli alkuun
        
        do {
            if (laskuri.pelivuoro == true) { //pelaajan pelivuoro
                int y;
                do {
                y = kysyLuku("Ammuksen sarakekoordinaatti?");
                if (y> kartta.sarakkeet) { JOptionPane.showMessageDialog(frame, "Sarakkeita on vain " + kartta.sarakkeet + "!"); }
                } while (y > kartta.sarakkeet);
                int z;
                do {
                z = kysyLuku("Ammuksen rivikoordinaatti?");
                if (z > kartta.rivit) { JOptionPane.showMessageDialog(frame, "Rivejä on vain " + kartta.rivit + "!"); }
                } while (z > kartta.rivit);
                ampuja.ammu(z-1, y-1); //pelaaja ampuu
                
                if (kartta.vihuPuoli[z-1][y-1].laivatyyppi >0) { //osuma
                    kartta.visualisoi();
                    laskuri.vihunRuudut --;
                    GUI.ilmoitus.setText("Osuma! Ammu uudestaan");
                    JOptionPane.showMessageDialog(frame, "Osuma! Ammu uudestaan");
                }
                
                else if (kartta.vihuPuoli[z-1][y-1].laivatyyppi == 0) { //huti
                    kartta.visualisoi();
                    GUI.ilmoitus.setText("Huti");
                    laskuri.seuraavaVuoro();
                }
                
            }
            
            if (laskuri.pelivuoro == false) { //vastustajan vuoro
                boolean sensori;
                boolean sensori2;
                sensori = ampuja.isku();
   
                if (sensori==true) { //osuu ekalla
                    laskuri.omatRuudut--;
                    JOptionPane.showMessageDialog(frame, "Vastustaja osui laivaan ruudussa" + (ampuja.ammuttuX+1) + "x" +(ampuja.ammuttuY+1));
                    
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
        GUI.ilmoitus.setText("Loppu");
        
    }
    
    
    //TYÖKALUMETODIT
    
    
    /**
     * Kysyy luvun ja tarkistaa että kyseessä on luku
     * @param kysymys Lause joka näytetään käyttäjälle
     * @return palauttaa tarkistetun luvun 
     */
    public static int kysyLuku(String kysymys) {
        String virheilmoitus = "";
        boolean toimii = true;
        int luku =-1;
        
        do {
        
            String vastaus = JOptionPane.showInputDialog(virheilmoitus + kysymys);
        
        try {
            vastaus = vastaus.trim(); //karsii mahdolliset välilyönnit
            luku = Integer.parseInt(vastaus);
            if (luku>0) {
                toimii = true;
                return luku;
            }
            else if (luku<=0) {
                toimii = false;
                virheilmoitus = "Luvun on oltava suurempi kuin nolla! ";
            }
        }
        
        catch (NumberFormatException e) {
            virheilmoitus = "Käytä vain numeroita! ";
            toimii = false;
        }
        
        catch (NullPointerException x) {
            virheilmoitus = "Elä jätä tyhjäksi! ";
            toimii = false;
        }
    } while (!toimii);
        return luku;
    }
}
