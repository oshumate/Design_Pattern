package observer;

/**
 * A Knight observes one or more {@link Subject} objects and responds
 * with protective or ceremonial actions based on the notice.
 */
public class Knight implements Observer {

    /**
     * Creates a Knight and registers it with the given subjects.
     *
     * @param watchman subject that may send warning notices
     * @param greeter  subject that may send greeting notices
     */
    public Knight(Subject watchman, Subject greeter) {
        if (watchman != null) watchman.registerObserver(this);
        if (greeter  != null) greeter.registerObserver(this);
    }

    /**
     * Handles updates by adding the appropriate knightly response.
     *
     * @param warning true if this is a warning notice
     * @param note    type of notice
     */
    @Override
    public void update(boolean warning, int note) {
        if (!warning) {
            if (note == 1) Subject.addMessage("Knight: Escort the messenger to the hall.");
            else            Subject.addMessage("Knight: Prepare the honor guard for royalty.");
        } else {
            if (note == 1) Subject.addMessage("Knight: Ready the defenses!");
            else            Subject.addMessage("Knight: Defend the city!");
        }
    }
}
