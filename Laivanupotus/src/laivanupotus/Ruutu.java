package laivanupotus;

/**
 * Ruutu on yksittäinen kartan kohta joka pitää kirjaa siinä mahdollisesti 
 * olevasta laivasta ja siihen osuvasta osumasta.
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
        laivatyyppi = 0;
        osuma = false;
    }
    
    //getterit
    
    public int getLaivatyyppi() {
        return this.laivatyyppi;
    }
    
    public boolean getOsuma() {
        return this.osuma;
    }
    
    //setterit
    
    public void setLaivatyyppi(int i) {
        this.laivatyyppi = i;
        return;
    }
    
    //Totuusarvo osuma on true kun ruutuun ammutaan
    
    public void Ammu() {
        this.osuma = true;
    }
    
    //toString
    
    public String toString() {
        String merkki = "";
        
        if (this.laivatyyppi > 0 && osuma == false) {
            merkki = "[S]";
        }
        
        if (this.laivatyyppi == 0 && osuma == true) {
            merkki = "[O]";
        }
        
        if (this.laivatyyppi == 0 && osuma == false) {
            merkki = "[ ]";
        }
        
        if (this.laivatyyppi > 0 && osuma == true) {
            merkki = "[X]";
        }
        return merkki;
    }
}
