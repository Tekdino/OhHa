package laivanupotus;

/**
 *Sisältää kaksi matriisillista ruutuja joista toinen näytetään omana ja toinen 
 *vastustajana (jonka laivat näkyvät vasta kun niihin on osuttu)
 */
public class Kartta {
    public int rivit;
    public int sarakkeet;
    public Ruutu[][] omaPuoli;
    public Ruutu[][] vihuPuoli;
    
    /**
     * Parametriton konstruktori luo perinteisen 10x10 ruudukon peliä varten.
     * Luokkaa ei kuitenkaan missään vaiheessa pysty enää lisäämään tällä tavalla
     * ainakaan pelin tämänhetkisessä toteutuksessa
     */
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
     * Luo jokaiseen matriisin lokeroon Ruudun. Ruuduissa ei oletuksena ole
     * laivoja eikä niihin ole ammuttu
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
     * Näyttää tekstiversion kartasta. Kerää tekstiesityksen yhteen StringBuilderilla
     * ja lähettää graafisen käyttöliittymän peliruutu-komponenttiin
     */
    public void visualisoi() {
        StringBuilder kokoa = new StringBuilder();
        
        kokoa.append("Vastustaja: " + "\n" );
        
        for (int sarakeluku=1; sarakeluku<vihuPuoli[1].length+1; sarakeluku++) {
            
            if (sarakeluku < 10) { kokoa.append("."+sarakeluku+"."); }
            else if (sarakeluku >= 10) { kokoa.append(sarakeluku+"."); }
        
        }
        kokoa.append("\n");
        
        for (int rivi=0; rivi<vihuPuoli.length; rivi++) {
            for (int sarake=0; sarake<vihuPuoli[rivi].length; sarake++) {
                kokoa.append(vihuPuoli[rivi][sarake].toString(false));
            }
            kokoa.append(rivi+"\n");
        }
        kokoa.append("Oma puoli: \n");
        
        for (int sarakeluku=1; sarakeluku<vihuPuoli[1].length+1; sarakeluku++) {
            
            if (sarakeluku < 10) { kokoa.append("."+sarakeluku+"."); }
            else if (sarakeluku >= 10) { kokoa.append(sarakeluku+"."); }
        }
        
        kokoa.append("\n");
        
        for (int rivi=0; rivi<omaPuoli.length; rivi++) {
            for (int sarake=0; sarake<omaPuoli[rivi].length; sarake++) {
                kokoa.append(omaPuoli[rivi][sarake].toString(true));
            }
            kokoa.append(rivi+1 + "\n");
        }
        GUI.peliruutu.setText(kokoa.toString());
    }
    
    /**
     * Näyttää vihollisen puolen yhtä avoimesti kuin oman puolen. Tämä perustuu
     * visualisoi() metodin vanhempaan versioon joka tulostaa kaiken system.out
     * printtauksilla. Luotu vain nopeita käsintehtäviä testejä varten
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
