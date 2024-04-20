package components.cipher;
import java.util.Arrays;
import java.util.Random;

/**
 * {@code Cipher} represented as a {@code Algorithm} with implementations of
 * secondary abstract methods.
 */
public abstract class CipherSecondary implements Cipher {

    /**
     * Encryption using Caesar cipher.
     * @param p
     * String password to be encrypted.
     * @return encrypted password.
     */
    private static String caesar(String p) {
      Random rand = new Random();
      int shift = rand.nextInt(14);

        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //password = password.toLowerCase();
        String result = "";
        for (int i = 0; i < p.length(); i++) {
            int charPos;
            int keyVal;
            char replace;

          if (alphabet.indexOf(p.charAt(i)) > 0) {
            charPos = alphabet.indexOf(p.charAt(i));
            keyVal = (shift + charPos) % 26;
            replace = alphabet.charAt(keyVal);

          } else if (alphabetBig.indexOf(p.charAt(i)) > 0) {
            charPos = alphabetBig.indexOf(p.charAt(i));
            keyVal = (shift + charPos) % 26;
            replace = alphabetBig.charAt(keyVal);

          } else {
            replace = p.charAt(i);
          }
          result += replace;
        }

        return result;
    }

    /**
     * Encryption using Affine cipher.
     * @param p
     *       String password to be encrypted.

     * @return encrypted password.
     */
    private static String affine(String p) {
      int b = 20;

      int[] array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
        53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
      Random rand = new Random();
      int index = rand.nextInt(array.length - 1);
      int a = array[index];


      String cipher;
      for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) != ' ') {
          cipher = cipher + (p) ((((a * (p.charAt(i) - 'A')) + b) % 26) + 'A');
        } else { // else simply append space character
          cipher += p.charAt(i);
        }
  }

  return cipher;

}

/**
     * Encryption using Rail cipher.
     * @param p
     *       String password to be encrypted.

     * @return encrypted password.
     */

private static String rail(String p) {
  Random rand = new Random();
  int key = rand.nextInt(50);

  char[][] rail = new char[key][p.length()];

  // filling the rail matrix to distinguish filled spaces from blank ones
  for (int i = 0; i < key; i++) {
    Arrays.fill(rail[i], '\n');
  }

  boolean down = false;
  int row = 0, col = 0;

  for (int i = 0; i < p.length(); i++) {


    if (row == 0 || row == key - 1) {
      down = !down;
    }

    rail[row][col++] = p.charAt(i);

    if (down) {
      row++;
    } else {
      row--;
    }
  }


  StringBuilder result = new StringBuilder();
  for (int i = 0; i < key; i++) {
    for (int j = 0; j < p.length(); j++) {
      if (rail[i][j] != '\n') {
        result.append(rail[i][j]);
      }
    }
  }

return result.toString(); //am i cooked
}


@Override

public final String toString() {
  String result = "CAESAR";
  if (this.equals(Algorithm.AFFINE)) {
    result = "AFFINE";
  } else if (this.equals(Algorithm.RAIL)) {
    result = "RAIL";
  }
  return result;
}



/**
     * Checks if 'this' equals Algorithm a.
     * @param a
     *       Algorithm to be compared to.

     * @return boolean value.
     */
public final boolean equals(Algorithm a) {

return this.equals(a); //enum

}


/**
 * Method to encrypt password based on current algorithm.
 * @param password to be encrypted
 * @return encrypted password.
 */

    public String encrypt(String password) {
      String result = password;
      switch (this.getAlgorithm()) {
        case CAESAR:
        result = caesar(password);
          break;

          case AFFINE:
          result = affine(password);
          break;

          case RAIL:
          result = rail(password);
          break;
        default:
          break;
      }



      return result;
    }

}
