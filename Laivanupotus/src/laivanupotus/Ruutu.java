package laivanupotus;

/**
 * Ruutu on yksittäinen kartan kohta joka pitää kirjaa siinä mahdollisesti 
 * olevasta laivasta ja siihen tulevasta osumasta.
 */
public class Ruutu {
    public int laivatyyppi;
    public boolean osuma;
    
    /**
     * @param laivatyyppi sisältää tiedon siitä minkä kokoista laivaa kyseisessä
     * ruudussa on
     * @param osuma on false kunnes ruutuun ammutaan
     */ 
    public Ruutu() {
        this.laivatyyppi = 0;
        this.osuma = false;
    }
    
    /**
     * Kuormitettu konstruktori nopeuttamaan ruudun asettamista tarvittaessa
     * @param i laivatyyppi (positiivinen kokonaisluku)
     * @param x totuusarvo, true = ruutuun on ammuttu
     */
    public Ruutu(int i, boolean x) {
        this.setLaivatyyppi(i);
        this.osuma = x;
    }
    
    //getterit
    
    /**
     * Palauttaa ruudun laivatyypin
     * @return laivatyyppi kertoo minkä kokoista laivaa tuossa ruudussa
     */
    public int getLaivatyyppi() {
        return this.laivatyyppi;
    }
    
    /**
     * Kertoo onko ruutuun ammuttu. EI SIIS kerro mitään mahdollisesta laivaan osumisesta
     * ilman että selvitetään myös onko kyseisen ruudun laivatyyppi > 0
     * @return 
     */
    public boolean getOsuma() {
        return this.osuma;
    }
    
    //setterit
    
    /**
     * "Maalaa" laivaa ruudulle. Jos laivatyypiksi annetaan negatiivinen,
     * käytetään arvoa 0
     * @param i laivatyyppi
     */
    public void setLaivatyyppi(int i) {
        if (i > -1) {
        this.laivatyyppi = i;
        return;
        }
        else {
            this.laivatyyppi = 0;
            return;
        }
    }
    
    //Totuusarvo osuma on true kun ruutuun ammutaan
    
    /**
     * Ammutaan ruutuun eli totuusarvo osuman arvoksi annetaan true
     * Toisin sanoen tämä on yksinkertainen setteri ellei tähän lisätä
     * tarkistusta siitä onko ruutuun jo ammuttu aikaisemmin. Säännöt eivät
     * kuitenkaan kiellä samaan ruutuun ampumista toista kertaa (jos pelaaja
     * jostain syystä haluaa) ja tekoäly tarkistaa ettei niin käy muualla
     */
    public void ammu() {
        this.osuma = true;
    }
    
    /**
     * Näyttää String-esityksen ruudusta. Jos tätä käytetään GUI:ssa, kannattaa
     * valita fontti jossa merkkien leveys heilahtelee mahdollisimman vähän
     * @param oma saa arvon true jos kyseessä on omalla puolella oleva ruutu
     * näyttää tällöin siinä olevan löytämättömän laivan
     */ 
    public String toString(boolean oma) {
        String merkki = "";
        
        if (this.laivatyyppi > 0 && osuma == false && oma == true) {
            merkki = "[S]";
        }
        
        //piilottaa löytämättömän laivan
        if (this.laivatyyppi > 0 && osuma == false && oma == false) {
            merkki = "[_]";
        }
        
        if (this.laivatyyppi == 0 && osuma == true) {
            merkki = "[O]";
        }
        
        if (this.laivatyyppi == 0 && osuma == false) {
            merkki = "[_]";
        }
        
        if (this.laivatyyppi > 0 && osuma == true) {
            merkki = "[X]";
        }
        return merkki;
    }
}
    