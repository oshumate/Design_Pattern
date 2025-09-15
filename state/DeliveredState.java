package state;

/**
 * Represents the state of a package that has been delivered.
 */
public class DeliveredState extends State {

    /**
     * Creates a DeliveredState for the given package.
     */
    public DeliveredState(Package pkg) {
        super(pkg);
    }

    /**
     * Returns a message saying the package has been delivered.
     */
    @Override
    public String getStatus() {
        return "The " + pkg.getName() + " " + pkg.getVerb("has", "have") + " been delivered.";
    }

    /**
     * Returns a message saying the package is already delivered.
     */
    @Override
    public String getETA() {
        return "The " + pkg.getName() + " " + pkg.getVerb("is", "are") + " already delivered.";
    }
}
