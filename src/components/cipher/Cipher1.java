package components.cipher;

/**
 * {@code Cipher} represented as a {@code Algorithm} with implementations of
 * primary methods.
 *
 * @convention <pre>
 * [all characters of $this.algo are of enums 'CAESR', 'AFFINE', and 'RAIL']  and
 * [$this.algo does not have two enum values]
 * </pre>
 * @correspondence <pre>
 * this = [if $this.algo is first initliaized, it is 'CAESAR'
 *         else, it can get reassigned the other enum values.]
 * </pre>
 *
 *
 * @author L
 *
 */

public class Cipher1 extends CipherSecondary {

    /**
     * Representation of {@code this}.
     */

    private Algorithm algo;

    /**
     * No-argument constructor.
     */
 public Cipher1() {
    this.createNewRep();

}

    /**
     * Creator of initial representation.
     */
 private void createNewRep() {
    this.algo = Algorithm.CAESAR;
}


/**
     * Reports the algorithm set.
     * @return Currently set algorithm
     */
    @Override
    public Algorithm getAlgorithm() {
        return this.algo;
    }

    /*
     * Clears "this".
     */
    @Override
    public final void clear() {
       this.createNewRep();
    }

    /**
     * Creates new instance of "this".
     * @return this.
     */
    @Override
    public final Cipher newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }




    /**
     * Sets "this.algo" to the algorithm of Cipher "a"
     * and clears "a" to be its initial value.
     * @param a
     * Cipher that replaces the old value of this.
     */
    @Override
    public void transferFrom(Cipher a) {
        this.algo = a.getAlgorithm();
        a.clear();
    }

/**
 * Sets desired encryption algorithm.
 *
 * @param a
 * Algorithm to encrypt in
 */
    @Override
    public void setAlgorithm(Algorithm a) {
        this.algo = a;
    }







 }
