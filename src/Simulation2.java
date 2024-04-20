import components.cipher.*;
import java.util.*;

import components.cipher.Cipher.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sample Code to show how this could be used to encrypt string passwords.
 * In this one, we are using a ".txt" file.
 * This is NOT meant to run! Just for an example, unlike Simulation1! :)
 */

public final class Simulation2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Simulation2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in));
        try {
            input = new BufferedReader(new FileReader("textt.txt"));
        } catch (IOException e) {
            System.err.println("Error opening file.");
        }


        Cipher a = new Cipher1();

        a.setAlgorithm(Algorithm.AFFINE);

        List<String> encryptedA = new ArrayList<>();
        String line = input.readLine();

        while (line != null) {
            String result = a.encrypt(line);
            encryptedA.add(result);
            line = input.readLine();
        }

        Algorithm b = a.getAlgorithm();

        if (!(b.equals(components.cipher.Cipher.Algorithm.RAIL))) {
            a.setAlgorithm(components.cipher.Cipher.Algorithm.RAIL);
        }

        List<String> encryptedR = new ArrayList<>();

        while (encryptedA.size() > 0) {
            String holder = encryptedA.removeFirst();
            String result = a.encrypt(holder);
            encryptedR.add(result);
        }

        System.out.println(encryptedR.toString());
        input.close();

    }

}

