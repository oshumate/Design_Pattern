// Subject.java
package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Subject} class represents the subject in the Observer design pattern.
 * It maintains a list of {@link Observer} objects that are notified when a notice is issued.
 */
public class Subject {

    /**
     * The list of observers subscribed to this subject.
     */
    protected ArrayList<Observer> observers = new ArrayList<>();

    /**
     * A static buffer used to temporarily store messages before printing.
     */
    private static final List<String> buffer = new ArrayList<>();

    /**
     * Adds a message to the shared buffer.
     */
    public static void addMessage(String line) {
        buffer.add(line);
    }

    /**
     * Prints all messages currently in the buffer to standard output,
     * then clears the buffer.
     */
    public static void printAllAndClear() {
        for (String s : buffer) {
            System.out.println(s);
        }
        buffer.clear();
    }

   
    public void registerObserver(Observer o) {
        if (o != null) observers.add(o);
    }

    
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Issues a notice to all observers with the given note.
     */
    public void issueNotice(int note) {
        notifyObservers(note);
    }

    /**
     * Notifies all registered observers with the given note.
     */
    public void notifyObservers(int note) {
        for (Observer o : observers) {
            o.update(false, note); // subclass sets warning flag
        }
    }
}
