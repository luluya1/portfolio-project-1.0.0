package components.cipher;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import components.cipher.Cipher.Algorithm;


/**
 * Test cases for the Cipher and secondary methods.
 */

public class CipherTest1 {

    /**
     * Testing the method "encrypt" by checking length.
     */

    @Test
    public final void testCaesar() {

        String p = "hello bestie pop";
        String pCopy = p;
        int len = p.length();

        Cipher a = new Cipher1();
        String result = a.encrypt(p);
        int expected = result.length();

        Algorithm b = a.getAlgorithm();

        assertEquals(pCopy, p);
        assertEquals(len, expected);
        assertEquals(a, b);

    }



     /**
     * Testing the Secondary method "equals", with a true result.
     */

     @Test
     public final void testEqualsTrue() {

         Algorithm a = Algorithm.AFFINE;
         boolean result = a.equals(Algorithm.AFFINE);

         assertEquals(true, result);

     }


     /**
     * Testing the Secondary method "equals", with a false result.
     */

     @Test
     public final void testEqualsFalse() {

        Algorithm a = Algorithm.RAIL;
        boolean result = a.equals(Algorithm.AFFINE);

        assertEquals(false, result);

     }

     /**
     * Testing the Secondary method "toString".
     */

     @Test
     public final void testToString() {

        Algorithm a = Algorithm.RAIL;
        String result = a.toString();

        assertEquals(result, "RAIL");

     }




}

