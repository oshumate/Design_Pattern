package observer;

/**
 * A Greeter is a {@link Subject} that sends non-warning notices
 * (e.g., messenger or royalty arrivals) to its observers.
 */
public class Greeter extends Subject {

    /**
     * Notifies all observers of a non-warning notice.
     *
     * @param note type of notice
     */
    @Override
    public void notifyObservers(int note) {
        for (Observer o : observers) o.update(false, note); 
    }

    /**
     * Issues a non-warning notice, displays all collected messages,
     * and plays the trumpet sound.
     *
     * @param note 1 = messenger, 2 = royalty
     */
    @Override
    public void issueNotice(int note) {
        notifyObservers(note);
        Subject.printAllAndClear();                 
        Trumpet.play(false, (note == 2) ? 2 : 1);    // 1× for messenger, 2× for royalty
    }
}
