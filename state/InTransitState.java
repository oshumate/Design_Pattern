package state;


/**
 * Represents the state of a package that is currently in transit
 */
public class InTransitState extends State {
    /** Default number of business days for shipping. */
    private int days = 5;

    /**
     * Constructs an InTransitState for the package
     */
    public InTransitState(Package pkg) {
        super(pkg);
    }

    /**
     * Returns a message describing the package status as being delidered
     */
    @Override
    public String getStatus() {
        return "The " + pkg.getName() + " " + pkg.getVerb("is", "are") + " out for delivery.";
    }

    /**
     * Returns an estimated time of arrival
     */
    @Override
    public String getETA() {
        int eta = days;
        if (random.nextDouble() < 0.30) { // 30% chance of delay
            eta += 1 + random.nextInt(7); // add 1–7 extra days
            return "The " + pkg.getName() + " " + pkg.getVerb("has", "have")
                 + " experienced a delay in shipping.\n"
                 + "The " + pkg.getName() + " should arrive within " + eta + " business days.";
        }
        return "The " + pkg.getName() + " should arrive within " + eta + " business days.";
    }
}
