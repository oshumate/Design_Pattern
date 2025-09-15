package state;

import java.util.Random;

/**
 * Abstract base class for all package states.
 * Each state must define its own status message and estimated time of arrival (ETA).
 */
public abstract class State {
    /** The package associated with this state. */
    protected final Package pkg;

    /** Random generator used to simulate delays. */
    protected final Random random;

    /**
     * Constructs a State for the given package.
     *
     * @param pkg the package associated with this state
     */
    public State(Package pkg) {
        this.pkg = pkg;
        this.random = new Random();
    }

    /**
     * Gets the package tied to this state.
     *
     * @return the package
     */
    protected Package getPackage() {
        return pkg;
    }

    /**
     * Gets the random number generator for delay simulation.
     *
     * @return the random generator
     */
    protected Random getRandom() {
        return random;
    }

    /**
     * Returns a message describing the current status of the package.
     *
     * @return status message
     */
    public abstract String getStatus();

    /**
     * Returns an estimated time of arrival (ETA) message for the package.
     *
     * @return ETA message
     */
    public abstract String getETA();
}
