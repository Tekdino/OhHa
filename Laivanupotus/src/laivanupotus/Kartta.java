package laivanupotus;

/**
 *Sisältää kaksi taulukollista ruutuja joista toinen näytetään omana ja toinen 
 *vastustajana (laivat näkyvät vain kun niihin on osuttu)
 */
public class Kartta {
    public int rivit;
    public int sarakkeet;
    public static Ruutu[][] omaPuoli;
    public static Ruutu[][] vihuPuoli;
    
    
    public Kartta() {
        omaPuoli = new Ruutu[10][10];
        vihuPuoli = new Ruutu[10][10];
        this.aseta();
    }
    
    /**
     * Muun kuin perinteisen 10x10 ruudukon luominen
     * @param y vaakaruutujen määrä
     * @param x pystyruutujen määrä
     */
    public Kartta (int y, int x) {
        rivit = x;
        sarakkeet = y;
        omaPuoli = new Ruutu[x][y];
        vihuPuoli = new Ruutu[x][y];
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
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++) {
                System.out.print(omaPuoli[rivi][sarake].toString(true));
            }
            System.out.print("\n");
        }
    }
      
}
