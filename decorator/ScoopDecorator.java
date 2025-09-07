package decorator;

/**
 * Abstract decorator for ice cream scoops.
 */
public class ScoopDecorator extends IceCream {
    /** Wrapped ice cream. */
    protected IceCream iceCream;
    /** Number of scoops for this flavor. */
    protected int numFlavorScoops;

    /**
     * Creates a scoop decorator.
     *
     * @param iceCream base ice cream
     * @param numScoops number of scoops
     */
    public ScoopDecorator(IceCream iceCream, int numScoops) {
        this.iceCream = iceCream;
        this.numFlavorScoops = numScoops;
    }
}
