package decorator;

import java.util.ArrayList;

/**
 * Concrete base cone for ice cream.
 */
public class Cone extends IceCream {
    /**
     * Creates a cone using ASCII art from a file.
     * The cone is colored brown.
     */
    public Cone() {
        final String ANSI_BROWN = "\u001B[38;5;130m";
        final String ANSI_RESET = "\u001B[0m";

        ArrayList<String> coneLines = FileReader.getLines("decorator/txt/cone.txt");
        ArrayList<String> colored = new ArrayList<>();

        for (String line : coneLines) {
            colored.add(ANSI_BROWN + line + ANSI_RESET);
        }

        this.asciiArt = colored;
        this.numScoops = 0;
    }
}
