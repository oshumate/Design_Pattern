package decorator;

import java.util.ArrayList;

/**
 * Represents an ice cream base component.
 * Holds ASCII art and number of scoops.
 */
public class IceCream {
    /** ASCII art lines for the ice cream. */
    protected ArrayList<String> asciiArt;
    /** Number of scoops so far. */
    protected int numScoops;

    /**
     * Returns a centered ASCII representation of the ice cream.
     * Scoop lines grow wider as they go down.
     *
     * @return ASCII art of the ice cream
     */
    @Override
    public String toString() {
        if (asciiArt == null) return "";

        ArrayList<String> rebuilt = new ArrayList<>();
        int seenScoops = 0;

        // 1. Expand scoop lines into (), ( - - ), ( - - - - ), ...
        for (String line : asciiArt) {
            String trimmed = line.trim();
            if (trimmed.contains("(") && trimmed.contains(")")) {
                int dashCount = seenScoops * 2;
                String inside = (dashCount == 0) ? "" : repeatWithSpaces('-', dashCount);
                String rebuiltLine = line.replaceFirst("\\(\\)", "(" + inside + ")");
                rebuilt.add(rebuiltLine);
                seenScoops++;
            } else {
                rebuilt.add(line);
            }
        }

        // 2. Find max visible width across all lines (scoops + cone).
        int maxWidth = 0;
        for (String line : rebuilt) {
            int visible = line.replaceAll("\u001B\\[[;\\d]*m", "").length();
            if (visible > maxWidth) {
                maxWidth = visible;
            }
        }

        // 3. Pad all lines so they are centered to the same width.
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < rebuilt.size(); i++) {
            String line = rebuilt.get(i);
            int visible = line.replaceAll("\u001B\\[[;\\d]*m", "").length();
            int pad = Math.max(0, (maxWidth - visible) / 2);
            out.append(" ".repeat(pad)).append(line);
            if (i < rebuilt.size() - 1) out.append("\n");
        }

        return out.toString();
    }

    /**
     * Builds a string with a character repeated and spaced.
     *
     * @param c character to repeat
     * @param n number of times
     * @return spaced sequence of characters
     */
    private String repeatWithSpaces(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(c);
        }
        return sb.toString();
    }
}
