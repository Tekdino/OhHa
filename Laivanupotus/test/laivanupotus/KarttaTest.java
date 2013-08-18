package laivanupotus;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * JUnit testit luokalle Kartta
 */
public class KarttaTest extends TestCase {
    private Kartta ruudukko;
    
    public void SetUp() {
        ruudukko = new Kartta(2,3);
    }
    
    // TODO Selvitä miks tää heittää NullPointerExceptionin
    
    public void testOikeaMaaraRiveja() {
        Assert.assertEquals("Väärä määrä rivejä", ruudukko.rivit, 2);
    }
    
    public void testOikeaMaaraSarakkeita() {
        Assert.assertEquals("Väärä määrä sarakkeita", ruudukko.sarakkeet, 3);
    }
}
