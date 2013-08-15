package laivanupotus;

// TODO Selvitä miks matriisi vaikuttas olevan täynnä nulleja ruutu-ilmentymien
//sijaa

/**
 *Sisältää kaksi taulukollista ruutuja joista toinen näytetään omana ja toinen 
 *vastustajana (laivat näkyvät vain kun niihin on osuttu)
 */
public class Kartta {
    public int rivit;
    public int sarakkeet;
    public Ruutu[][] omaPuoli;
    public Ruutu[][] vihuPuoli;
    
    
    public Kartta() {
        Ruutu[][] omaPuoli = new Ruutu[10][10];
        Ruutu[][] vihuPuoli = new Ruutu[10][10];
        this.aseta();
    }
    
    /**
     * Muun kuin perinteisen 10x10 ruudukon luominen
     * @param x vaakaruutujen määrä
     * @param y pystyruutujen määrä
     */
    public Kartta (int x, int y) {
        rivit = x;
        sarakkeet = y;
        Ruutu[][] omaPuoli = new Ruutu[x][y];
        Ruutu[][] vihuPuoli = new Ruutu[x][y];
        this.aseta();
    }
    
    /**
     * Luo jokaiseen matriisin lokeroon Ruudun
     */
    public void aseta() {
        for (int rivi=0; rivi<rivit; rivi++) {
            for (int sarake=0; sarake<sarakkeet; sarake++)
                omaPuoli[rivi][sarake] = new Ruutu(0, false);
        }
    }
    
    /**
     * Näyttää tekstiversion kartasta
     *  TODO koordinaatisto reunoille!
     */
    public void visualisoi() {
        for (int rivi=0; rivi<omaPuoli.length; rivi++) {
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++)
                System.out.println(omaPuoli[rivi][sarake]);
        }
    }
      
}
