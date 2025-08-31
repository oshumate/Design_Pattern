package observer;

/**
 * A ShopOwner observes one or more {@link Subject} objects and reacts
 * with business-related actions based on normal or warning notices.
 */
public class ShopOwner implements Observer {

    /**
     * Creates a ShopOwner and registers it with the given subjects.
     *
     * @param watchman subject that may send warning notices
     * @param greeter  subject that may send greeting notices
     */
    public ShopOwner(Subject watchman, Subject greeter) {
        if (watchman != null) watchman.registerObserver(this);
        if (greeter  != null) greeter.registerObserver(this);
    }

    /**
     * Handles updates by adding the appropriate shop response.
     *
     * @param warning true if this is a warning notice
     * @param note    type of notice
     */
    @Override
    public void update(boolean warning, int note) {
        if (!warning) {
            if (note == 1) Subject.addMessage("ShopOwner: A messenger is coming! Get the goods ready.");
            else            Subject.addMessage("ShopOwner: Royalty is approaching, display our best items!");
        } else {
            if (note == 1) Subject.addMessage("ShopOwner: An army is approaching! Close this shop!");
            else            Subject.addMessage("ShopOwner: The city is breached! Hide everything quick!");
        }
        // sound handled by Greeter/Watchman after all messages are buffered
    }
}
