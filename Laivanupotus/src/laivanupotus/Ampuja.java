package laivanupotus;
import java.util.Random;

/**
 *Luokka sisältää koordinaatteihin ampumisessa tarvitun toiminnallisuuden
 */
public class Ampuja {
    Kartta kartta;
    int ammuttuX;
    int ammuttuY;
    
    /**
     * Uusi olio tarvitsee parametrina valmiin Kartan
     * @param peli luokan käyttämä Kartta
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
     * Ammutaan satunnaiseen kohtaan. Huom, ampuminen tulee johonkin pelaajan
     * puolen ruuduista sillä metodi on tekoälyn käytössä. Ei ammu sellaiseen
     * ruutuun johon on jo ammuttu aikaisemmin
     */
    public boolean isku() {
        Random arpoja = new Random();
        int x;
        int y;
        do {
        x = arpoja.nextInt(kartta.rivit);
        y = arpoja.nextInt(kartta.sarakkeet);
        } while (kartta.omaPuoli[x][y].osuma == true); //arpoo ruutuja kunnes löytää vapaan
        
        kartta.omaPuoli[x][y].ammu(); //ampuu vapaaseen ruutuun
        ammuttuX = x;
        ammuttuY = y;
        if (kartta.omaPuoli[x][y].laivatyyppi>0) { //osuu laivaan
            return true;
        }
        else return false; //ei osu laivaan
    }
    
    /**
     * Ammutaan (vastustaja ampuu) sopivaan kohtaan annettujen koordinaattien vieressä
     * Palauttaa arvonaan true jos onnistui, false jos ei
     */
    public boolean viereen(int x, int y) {
        Random valitsija = new Random();
        int m;
        int f;
        
        do {
        
        int d = valitsija.nextInt(3)+1; //arpoo luvun välillä 1-4
        
        if (d==1) { //oikean puoleinen ruutu
            if (x<kartta.sarakkeet) { //ruutu ei oo oikeessa reunassa
                m = x+1;
                f = y;
                if (kartta.omaPuoli[m][f].osuma == false) {
                    kartta.omaPuoli[m][f].ammu();
                    return true;
                }
                else return false;
            }
        }
        
        if (d==2) { //vasemman puoleinen ruutu
            if (x>1) { //ruutu ei oo vasemmassa reunassa
                m = x-1;
                f = y;
                if (kartta.omaPuoli[m][f].osuma == false) {
                    kartta.omaPuoli[m][f].ammu();
                    return true;
                }
                else return false;
            }
        }
        
        if (d==3) { //yläpuolinen ruutu
            if (y<kartta.rivit) { //ruutu ei oo yläreunassa
                m = x;
                f = y-1;
                if (kartta.omaPuoli[m][f].osuma == false) {
                    kartta.omaPuoli[m][f].ammu();
                    return true;
                }
                else return false;
            }
        }
        
        if (d==4) { //alapuolinen ruutu
            if (y<1) { //ruutu ei oo alareunassa
                m = x;
                f = y+1;
                if (kartta.omaPuoli[m][f].osuma == false) {
                    kartta.omaPuoli[m][f].ammu();
                    return true;
                }
                else return false;
            }
        }
        } while (true);
    }
}
