package components.cipher;
import components.cipher.Cipher.Algorithm;
import components.standard.Standard;

/**
 * Kernel interface.
 */

public interface CipherKernel extends Standard<Cipher> {

    /**
     * Sets {@code a} as the desired encryption algorithm.
     *
     * @param a
     *            the algorithm to encrypt the password in.
     *
     * @updates algorithm
     * @ensures {@code a = algorithm}
     */
    void setAlgorithm(Algorithm a);

    /**
     * Returns the current algorithm.
     *
     * @return the currently set algorithm to encrypt the password in.
     * @ensures {@code a = algorithm}
     */
    Algorithm getAlgorithm();

}
