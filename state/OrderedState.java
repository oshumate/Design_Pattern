package state;


/**
 * Represents the state of a package that has been ordered but not shipped
 */
public class OrderedState extends State {
    /** Default number of business days before shipping. */
    private int days = 2;

    /**
     * Constructs an OrderedState for the package.
     *
     * @param pkg the package associated with this state
     */
    public OrderedState(Package pkg) {
        super(pkg);
    }

    /**
     * Returns a message describing the status of the package
     *
     * @return status message
     */
    @Override
    public String getStatus() {
        return "The " + pkg.getName() + " " + pkg.getVerb("was", "were") + " ordered.";
    }

    /**
     * Returns an estimated time of arrival
     *
     * @return ETA message
     */
    @Override
    public String getETA() {
        int eta = days;
        if (random.nextDouble() < 0.20) { // 20% chance of delay
            eta += 1 + random.nextInt(3); // add 1–3 extra days
            return "The " + pkg.getName() + " " + pkg.getVerb("has", "have")
                 + " experienced a slight delay.\n"
                 + "The " + pkg.getName() + " will be shipped within " + eta + " business days.";
        }
        return "The " + pkg.getName() + " will be shipped within " + eta + " business days.";
    }
}
