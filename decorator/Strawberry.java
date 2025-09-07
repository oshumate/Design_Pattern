package decorator;

import java.util.ArrayList;

/**
 * Strawberry scoop decorator.
 */
public class Strawberry extends ScoopDecorator {
    /**
     * Creates strawberry scoops on top of the ice cream.
     *
     * @param iceCream base ice cream
     * @param numScoops number of strawberry scoops
     */
    public Strawberry(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);

        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        ArrayList<String> built = new ArrayList<>();
        for (int i = 0; i < numFlavorScoops; i++) {
            built.add(ANSI_RED + "()" + ANSI_RESET);
        }

        if (iceCream.asciiArt != null) built.addAll(iceCream.asciiArt);

        this.asciiArt = built;
        this.numScoops = iceCream.numScoops + numFlavorScoops;
    }
}
