import java.util.*;
import components.cipher.*;
import components.cipher.Cipher.Algorithm;

/**
 * Sample Code to show how this could be used to encrypt string passwords. :)
 */

public final class Simulation1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Simulation1() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {


        String[] array = {"hello!", "goodbye", "hey it's me Goku"};
        Cipher a = new Cipher1();


        if (a.equals(Algorithm.CAESAR)) {
            a.setAlgorithm(Algorithm.RAIL);
        }

        String[] encrypted = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            String yurr = array[i];
            String result = a.encrypt(yurr);
            encrypted[i] = result;
            array[i] = null;

        }

        System.out.println(Arrays.toString(encrypted));






    }



}
