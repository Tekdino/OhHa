package laivanupotus;

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
        rivit = 10;
        sarakkeet = 10;
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
            for (int sarake=0; sarake<sarakkeet; sarake++) {
                omaPuoli[rivi][sarake] = new Ruutu(0, false);
                vihuPuoli[rivi][sarake] = new Ruutu(0, false);
            }
        }
    }
    
    /**
     * Näyttää tekstiversion kartasta
     */
    public void visualisoi() {
        System.out.println("Vastustaja:");
        
        for (int sarakeluku=1; sarakeluku<vihuPuoli.length+1; sarakeluku++) {
            System.out.print("."+sarakeluku+".");
        }
        System.out.print("\n");
        
        for (int rivi=0; rivi<vihuPuoli.length; rivi++) {
            for (int sarake=0; sarake<vihuPuoli[rivi].length; sarake++) {
                System.out.print(vihuPuoli[rivi][sarake].toString(false));
            }
            System.out.println(rivi+1);
        }
        System.out.println("Oma puoli:");
        
        for (int sarakeluku=1; sarakeluku<vihuPuoli.length+1; sarakeluku++) {
            System.out.print("."+sarakeluku+".");
        }
        
        System.out.print("\n");
        
        for (int rivi=0; rivi<omaPuoli.length; rivi++) {
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++) {
                System.out.print(omaPuoli[rivi][sarake].toString(true));
            }
            System.out.println(rivi+1);
        }
    }
    
    /**
     * Näyttää vihollisen puolen yhtä avoimesti kuin oman puolen
     */
    public void debugVisualisoi() {
        System.out.println("Vastustaja:");
        for (int rivi=0; rivi<vihuPuoli.length; rivi++) {
            for (int sarake=0; sarake<vihuPuoli[rivi].length; sarake++) {
                System.out.print(vihuPuoli[rivi][sarake].toString(true));
            }
            System.out.print("\n");
        }
        System.out.println("Oma puoli:");
        for (int rivi=0; rivi<omaPuoli.length; rivi++) {
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++) {
                System.out.print(omaPuoli[rivi][sarake].toString(true));
            }
            System.out.print("\n");
        }
    }
      
}
