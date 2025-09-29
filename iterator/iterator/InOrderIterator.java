//Owen Shumate
package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator that plays songs in order.
 */
public class InOrderIterator implements Iterator<Song> {
    /** Array of songs to iterate through. */
    private final Song[] songs;

    /** Current position in the array. */
    private int position;

    /**
     * Constructs an InOrderIterator for the given array of songs.
     *
     * @param songs 
     */
    public InOrderIterator(Song[] songs) {
        this.songs = songs;
        this.position = 0;
    }

    /**
     * Checks if there are more songs left in the album.
     *
     * @return 
     */
    @Override
    public boolean hasNext() {
        return position < songs.length;
    }

    /**
     * Returns the next song in order.
     *
     * @return the next Song
     * @throws NoSuchElementException
     */
    @Override
    public Song next() {
        if (!hasNext()) throw new NoSuchElementException("No more songs (in-order).");
        return songs[position++];
    }
}
