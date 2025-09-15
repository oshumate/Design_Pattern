package state;

/**
 * Represents a package that can move through different states
 */
public class Package {

    private final String name; //name of package
    private final int quantity; //quantity of package
    private State state; //current state
    private final State orderedState; //order state
    private final State inTransitState; //in transit state
    private final State deliveredState; // delivery state

    /**
     * Constructs a Package with the name and quantity.
     */
    public Package(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;

        this.orderedState   = new OrderedState(this);
        this.inTransitState = new InTransitState(this);
        this.deliveredState = new DeliveredState(this);

        this.state = orderedState;
    }

    /**
     * Moves package to the ordered state.
     */
    public String order() {
        setState(orderedState);
        return state.getStatus() + "\n" + state.getETA();
    }

    /**
     * Moves package to the in-transit state.
     */
    public String mail() {
        setState(inTransitState);
        return state.getStatus() + "\n" + state.getETA();
    }

    /**
     * Moves package to the delivered state.
     */
    public String received() {
        setState(deliveredState);
        return state.getStatus() + "\n" + state.getETA();
    }

    /**
     * Sets the current state of the package.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets the name of the package.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the correct verb form depending on quantity.
     *
     * @param singular verb form for singular quantity
     * @param plural   verb form for plural quantity
     */
    public String getVerb(String singular, String plural) {
        return quantity == 1 ? singular : plural;
    }


    /**
     * Gets the ordered state.
     *
     * @return the ordered state
     */
    public State getOrderedState() {
        return orderedState;
    }

    /**
     * Gets the in-transit state.
     *
     * @return the in-transit state
     */
    public State getInTransitState() {
        return inTransitState;
    }

    /**
     * Gets the delivered state.
     *
     * @return the delivered state
     */
    public State getDeliveredState() {
        return deliveredState;
    }
}
