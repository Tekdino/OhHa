package laivanupotus;


public class Laivanupotus {


    public static void main(String[] args) {
        //pikatesti
        Kartta kartta = new Kartta(5,5);
        Ampuja ampuja = new Ampuja(kartta);
        Laskuri laskuri = new Laskuri(kartta);
        Laivaaja laivaaja = new Laivaaja(laskuri);
        laivaaja.laivaa(3, 0, 1, 2, true);
        
        for (int i=0; i<10; i++) {
            ampuja.isku();
        }
        kartta.visualisoi();
    }
}
