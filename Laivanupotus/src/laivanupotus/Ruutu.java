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
    
    public int getLaivatyyppi() {
        return this.laivatyyppi;
    }
    
    public boolean getOsuma() {
        return this.osuma;
    }
    
    //setterit
    
    /**
     * "Maalaa" laivaa ruudulle. Jos laivatyyppi on negatiivinen,
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
    
    public void ammu() {
        this.osuma = true;
        // TODO Selvitä laivatilanne ja kerro laskurille tjsp
    }
    
    /**
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
    