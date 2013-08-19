package laivanupotus;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * JUnit testit luokalle Ampuja
 */
public class AmpujaTest extends TestCase {
    private Ampuja ampuja;
    private Kartta kartta;
    
    public void setUp() {
        kartta = new Kartta(5,5);
        ampuja = new Ampuja(kartta);
        ampuja.ammu(2,3);
    }
    
    public void testAmpuminenOikeaanRuutuun() {
        Assert.assertEquals("Ampuminen ei osunut oikeaan ruutuun",kartta.vihuPuoli[2][3].osuma, true);
    }
    
    public void testVihunAmpuminenEiVaikutaOmiinRuutuihin() {
        Assert.assertEquals("Vasustajan ampuminen osui myös omaan ruutuun", kartta.omaPuoli[2][3].osuma, false);
    }
}
