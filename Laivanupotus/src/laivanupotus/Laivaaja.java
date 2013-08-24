package laivanupotus;
import java.util.Random;

/**
 *Sisältää työkalut kartan täyttämiseen laivoilla (myös arvotun)
 */
public class Laivaaja {
    Laskuri laskuri;
    int vapaaX;
    int vapaaY;
    
    /**
     * Vaatii valmiin Tallentajan (joka siis sisältää Kartan)
     * @param kirjanpito Tallentaja-luokka joka sisältää
     */
    public Laivaaja(Laskuri kirjanpito) {
        laskuri = kirjanpito;
    }
    
    /**
     * Arpoo ruutuja kunnes löytää vapaan ruudun, merkitsee tuon ruudun koordinaatit
     * muuttujien vapaaX ja vapaaY arvoiksi
     */
    public void arvoRuutu() {
        Random noppa = new Random();
        int x;
        int y;
        do {
        x = noppa.nextInt(laskuri.kartta.rivit);
        y = noppa.nextInt(laskuri.kartta.sarakkeet);
        }
        while (laskuri.kartta.vihuPuoli[x][y].laivatyyppi!=0);
        vapaaX = x;
        vapaaY = y;
}
    
    /**
     * Etsii tietyn pituiselle laivalle vapaan asennon alkaen annetusta ruudusta
     * (Voidaan käyttää muuttujien vapaaX ja vapaaY arvoja ruudun valintaan)
     * Palauttaa true jos onnistui ja false jos ei onnistu
     * HUOM! Olettaa että annettu ruutu on jo tarkistettu vapaaksi esim arvoRuutu()
     * metodilla!
     * @param laivanPituus Minkä pituiselle laivalle etsitään paikkaa
     * @param rivi Tunnusteltavan koordinaatin rivi
     * @param sarake Tunnusteltavan koordinaatin sarake
     */
    public boolean tunnusteleLaiva(int laivanPituus, int rivi, int sarake) {
        Random suunta = new Random(); //1 = vaaka, 2 = pysty
        int z = suunta.nextInt(1)+1; //arpoo joko luvun 1 tai 2
        if (z==1) {
            if ((sarake + laivanPituus) <= laskuri.kartta.rivit) { //laiva mahtuu näinpäin
                laivaa(laivanPituus, rivi, sarake, z, false); //laitetaan laiva tuohon kohtaan
                return true;
            }
            else return false; //laiva ei mahtunut
            }
        if (z==2) {
            if ((rivi + laivanPituus) <= laskuri.kartta.sarakkeet) { //laiva mahtuu näinpäin
                laivaa(laivanPituus, rivi, sarake, z, false); //laitetaan laiva tuohon kohtaan
                return true;
            }
            else return false; //laiva ei mahtunut
        }
        return false;
    }
    
    /**
     * Täyttää ilmoitetun kohdan laivalla (paikka pitää tarkistaa ensin tunnusteleLaiva
     * metodilla
     * @param laivanPituus asetettavan laivan pituus
     * @param rivi rivikoordinaatti josta laiva alkaa
     * @param sarake sarakekoordinaatti josta laiva alkaa
     * @param suunta 1 = vaaka, 2 = pysty
     * @param oma true = laitetaan laiva omalle puolelle, false = laitetaan vastustajan puolelle
     */
    public void laivaa(int laivanPituus, int rivi, int sarake, int suunta, boolean oma) {
        //laiva omalle puolelle
        if (oma = true) {
          if (suunta == 1) { //vaakatasoon
            for (int i=0; i<laivanPituus; i++) {
            laskuri.kartta.omaPuoli[rivi][sarake+i].laivatyyppi = laivanPituus;
          }
          }
          if (suunta == 2) { //pystysuuntaan
            for (int i=0; i<laivanPituus; i++) {
                laskuri.kartta.omaPuoli[rivi+i][sarake].laivatyyppi = laivanPituus;
            } 
          }
          }
        //laiva vastustajan puolelle
        else if (oma = false) {
          if (suunta == 1) { //vaakatasoon
            for (int i=0; i<laivanPituus; i++) {
            laskuri.kartta.vihuPuoli[rivi][sarake+i].laivatyyppi = laivanPituus;
          }
          }
          if (suunta == 2) { //pystysuuntaan
            for (int i=0; i<laivanPituus; i++) {
                laskuri.kartta.vihuPuoli[rivi+i][sarake].laivatyyppi = laivanPituus;
            } 
          }
          }
    }
}
