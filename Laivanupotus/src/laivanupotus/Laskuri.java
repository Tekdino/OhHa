package laivanupotus;

/**
 *Pitää kirjaa vuoroista, osumista, jäjellä olevista laivoista jne. Antaa pelin
 * lopuksi tiedot tallentajalle
 */
public class Laskuri {
    Kartta kartta;
    int vuoronumero = 1; //laskee vuoroja
    boolean pelivuoro = true; //sallii pelaajan syötöt vain omalla vuorolla kun totuusarvo on true
    int osumat = 0; //laskee osumia viholliseen
    int[] omiaLaivoja; //taulukko johon listattu jäljellä olevien laivojen määrät
    int[] vihunLaivoja; //niin että paikassa [1]=laivatyyppi ykkösen laivat jne
    
    /**
     * Uusi laskuri tarvitsee parametrina valmiin Kartan
     * @param peli Luokan käyttämä Kartta
     */
    public Laskuri (Kartta peli) {
        kartta = peli;
    }
    
    //getterit
    
    public int getVuoronumero() {
        return this.vuoronumero;
    }
    
    public boolean getPelivuoro() {
        return this.pelivuoro;
    }
    
    public int getOsumat() {
        return this.osumat;
    }
    
    /**
     * Ei anna koko taulukkoa vaan annetun kohdan luvun
     * @param tyyppi esim jos tyyppi = 1, kerrotaan kuinka monta ykköstyypin laivaa on jäljellä
     * @return katso ylempi
     */
    public int getOmiaLaivoja(int tyyppi) {
        return this.omiaLaivoja[tyyppi];
    }
    
    /**
     * Ei anna koko taulukkoa vaan annetun kohdan luvun
     * @param tyyppi esim jos tyyppi = 1, kerrotaan kuinka monta ykköstyypin laivaa on jäljellä
     * @return katso ylempi
     */
    public int getVihunLaivoja(int tyyppi) {
        return this.vihunLaivoja[tyyppi];
    }
    
    //setterit
    
    /**
     * Siirtää laskurin seuraavaan (vastustajan) pelivuoroon
     */
    public void seuraavaVuoro() {
        this.vuoronumero++;
        pelivuoro = false;
    }
    
    /**
     * Laskee uuden osuman mukaan
     */
    public void lisaaOsuma() {
        this.osumat++;
    }
    
    /**
     * Asettaa laskurin taulukkoon laivatyypit ja -määrät
     * @param oma true = omia laivoja, false = vastustajan laivoja
     * @param tyyppi laivan tyyppi
     * @param maara tämän tyyppisten laivojen määrä
     */
    public void asetaLaivoja(boolean oma, int tyyppi, int maara) {
        if (oma == true) {
            this.omiaLaivoja[tyyppi] = maara;
        }
        else if (oma == false) {
            this.vihunLaivoja[tyyppi] = maara;
        }
    }
}
