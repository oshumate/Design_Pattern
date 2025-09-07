package decorator;

import java.util.ArrayList;

/**
 * Vanilla scoop decorator.
 */
public class Vanilla extends ScoopDecorator {
    /**
     * Creates vanilla scoops on top of the ice cream.
     *
     * @param iceCream base ice cream
     * @param numScoops number of vanilla scoops
     */
    public Vanilla(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);

        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_RESET = "\u001B[0m";

        ArrayList<String> built = new ArrayList<>();
        for (int i = 0; i < numFlavorScoops; i++) {
            built.add(ANSI_WHITE + "()" + ANSI_RESET);
        }

        if (iceCream.asciiArt != null) built.addAll(iceCream.asciiArt);

        this.asciiArt = built;
        this.numScoops = iceCream.numScoops + numFlavorScoops;
    }
}
