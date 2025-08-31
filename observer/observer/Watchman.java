package observer;

/**
 * A Watchman is a {@link Subject} that sends warning notices
 * to its observers.
 */
public class Watchman extends Subject {

    /**
     * Notifies all observers of a warning with the given note.
     *
     * @param note type of warning notice
     */
    @Override
    public void notifyObservers(int note) {
        for (Observer o : observers) o.update(true, note);
    }

    /**
     * Issues a warning notice, displays all collected messages,
     * and plays the trumpet sound.
     *
     * @param note 1 = army approaching, 2 = city breached
     */
    @Override
    public void issueNotice(int note) {
        notifyObservers(note);
        Subject.printAllAndClear();                  
        Trumpet.play(true, (note == 2) ? 2 : 1);     // 1× for army, 2× for breach
    }
}
