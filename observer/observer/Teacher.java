package observer;

/**
 * A Teacher observes one or more {@link Subject} objects and reacts
 * with classroom instructions based on normal or warning notices.
 */
public class Teacher implements Observer {

    /**
     * Creates a Teacher and registers it with the given subjects.
     *
     * @param watchman subject that may send warning notices
     * @param greeter  subject that may send greeting notices
     */
    public Teacher(Subject watchman, Subject greeter) {
        if (watchman != null) watchman.registerObserver(this);
        if (greeter  != null) greeter.registerObserver(this);
    }

    /**
     * Handles updates by adding the appropriate classroom message.
     *
     * @param warning true if this is a warning notice
     * @param note    type of notice
     */
    @Override
    public void update(boolean warning, int note) {
        if (!warning) {
            if (note == 1) Subject.addMessage("Teacher: Class, a messenger is approaching!");
            else            Subject.addMessage("Teacher: Class, line up to greet the royalty.");
        } else {
            if (note == 1) Subject.addMessage("Teacher: Evacuation, move to safety!");
            else            Subject.addMessage("Teacher: Shelter in place and remain calm!");
        }
    }
}
