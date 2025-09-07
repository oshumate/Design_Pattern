package decorator;

import java.util.ArrayList;

/**
 * Blueberry scoop decorator.
 */
public class BlueBerry extends ScoopDecorator {
    /**
     * Creates blueberry scoops on top of the ice cream.
     *
     * @param iceCream base ice cream
     * @param numScoops number of blueberry scoops
     */
    public BlueBerry(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);

        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";

        ArrayList<String> built = new ArrayList<>();
        for (int i = 0; i < numFlavorScoops; i++) {
            built.add(ANSI_BLUE + "()" + ANSI_RESET);
        }

        if (iceCream.asciiArt != null) built.addAll(iceCream.asciiArt);

        this.asciiArt = built;
        this.numScoops = iceCream.numScoops + numFlavorScoops;
    }
}
