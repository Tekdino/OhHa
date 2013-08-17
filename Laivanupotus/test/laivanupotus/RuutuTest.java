package laivanupotus;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * JUnit testit luokalle Ruutu
 */
public class RuutuTest extends TestCase {
    private Ruutu oma;
    private Ruutu vihu;
    private Ruutu vihu2;
    
    public void setUp() {
        oma = new Ruutu(1, false);
        vihu = new Ruutu(-2, false);
        vihu2 = new Ruutu(1, false);
        vihu.ammu();
        vihu2.ammu();
    }
    
    public void testPositiivinenLaivatyyppi() {
        Assert.assertEquals("Positiivinen laivatyyppi ei tallentunut", oma.laivatyyppi, 1);
    }
    
    public void testNegatiivinenLaivatyyppi() {
        Assert.assertEquals("Negatiivinen laivatyyppi hyväksyttiin", vihu.laivatyyppi, 0);
    }
    
    public void testAmpumattomuus() {
        Assert.assertEquals("Ruutu ei ollut koskematon", oma.osuma, false);
    }
    
    public void testAmmu() {
        Assert.assertEquals("Osuma ei tallentunut", vihu.osuma, true);
    }

    public void testToStringOmaLaivaRuudussa() {
        Assert.assertEquals("Tyhjän ruudun toString ei toimi", "[S]", oma.toString(true));
    }
    
    public void testToStringKunOsutaanVihuun() {
        Assert.assertEquals("toString ei toimi kun osutaan vihuun","[X]", vihu2.toString(false));
    }
    
    public void testToStringOsumaOmaanLaivaan() {
        oma.ammu();
        Assert.assertEquals("toString ei toimi kun osutaan omaan laivaan", "[X]", oma.toString(true));
    }
}
