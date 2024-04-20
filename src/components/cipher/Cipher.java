package components.cipher;


/**
 * Interface that extends Kernel methods for the Cipher components.
 */

public interface Cipher extends CipherKernel {

    /**
     * Algorithms to be used in encryption.
     */

    enum Algorithm {

        /**
         * Algorithms to be used in encryption.
         */
        CAESAR, AFFINE, RAIL
    }

    /**
     * Encrypts {@code password} with the current algorithm and returns the new
     * password.
     *
     * @param password
     *            the string to be encrypted.
     * @return The encrypted password.
     *
     * @ensures {@code password} is unchanged.
     */
    String encrypt(String password);




}
