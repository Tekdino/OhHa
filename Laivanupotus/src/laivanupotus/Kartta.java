package laivanupotus;

// TODO Selvitä miks matriisi vaikuttas olevan täynnä nulleja ruutu-ilmentymien
//sijaa

/**
 *Sisältää kaksi taulukollista ruutuja joista toinen näytetään omana ja toinen 
 *vastustajana (laivat näkyvät vain kun niihin on osuttu)
 */
public class Kartta {
    private int vaaka;
    private int pysty;
    Ruutu[][] omaPuoli = new Ruutu[vaaka][pysty];
    Ruutu[][] vihuPuoli = new Ruutu[vaaka][pysty];
    
    
    public Kartta() {
        vaaka = 10;
        pysty = 10;
    }
    
    /**
     * Muun kuin perinteisen 10x10 ruudukon luominen
     * @param x vaakaruutujen määrä
     * @param y pystyruutujen määrä
     */
    public Kartta(int x, int y) {
        vaaka = x;
        pysty = y;
    }
    
    public void visualisoi() {
        for (int rivi=0; rivi<omaPuoli.length; rivi++) {
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++)
                System.out.println(omaPuoli[rivi][sarake]);
        }
    }
      
}
