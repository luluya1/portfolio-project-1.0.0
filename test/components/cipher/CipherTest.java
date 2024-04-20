package components.cipher;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import components.cipher.Cipher.Algorithm;


/**
 * Test cases for the Cipher standard and kernel methods.
 */

public class CipherTest {



    /**
     * Testing the Standard method "clear".
     */

     @Test
     public final void testClear() {

        Cipher a = new Cipher1();

         a.setAlgorithm(Algorithm.AFFINE);
         a.clear();

         assertEquals(a, Algorithm.CAESAR);

     }

     /**
     * Testing the Standard method "newInstance".
     */

     @Test
     public final void testNewInstance() {

        Cipher a = new Cipher1();
        a.setAlgorithm(Algorithm.RAIL);
        Algorithm aAlgo = a.getAlgorithm();

        Cipher b = a.newInstance();
        Algorithm bAlgo = b.getAlgorithm();

         assertEquals(a, b);
         assertEquals(aAlgo, bAlgo);

     }

     /**
     * Testing the Standard method "transferFrom".
     */

     @Test
     public final void testTransferFrom() {

        Cipher a = new Cipher1();
        a.setAlgorithm(Algorithm.RAIL);


         Cipher b = new Cipher1();
         b.transferFrom(a);

         Algorithm aAlgo = a.getAlgorithm();

         Algorithm bAlgo = b.getAlgorithm();

         assertEquals(aAlgo, Algorithm.CAESAR);
         assertEquals(bAlgo, Algorithm.AFFINE);

     }


     /**
     * Testing the Kernel method "setAlgorithm".
     */

     @Test
     public final void testSetAlgo() {

        Cipher a = new Cipher1();
        a.setAlgorithm(Algorithm.RAIL);
        Algorithm aAlgo = a.getAlgorithm();

         assertEquals(aAlgo, Algorithm.RAIL);

     }

     /**
     * Testing the Kernel method "getAlgorithm".
     */

     @Test
     public final void testGetAlgo() {

        Cipher a = new Cipher1();

        a.setAlgorithm(Algorithm.RAIL);
        Algorithm aAlgo = a.getAlgorithm();
        String str = aAlgo.toString();

        assertEquals(aAlgo, Algorithm.RAIL);
        assertEquals("RAIL", str);

     }

}
