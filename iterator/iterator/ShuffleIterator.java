//Owen Shumate
package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Iterator that plays songs in a random order.
 */
public class ShuffleIterator implements Iterator<Song> {
    /** Array of songs to iterate through */
    private final Song[] songs;

    /** Current position in the array. */
    private int position;

    /** Random generator used for shuffling. */
    private final Random rand;

    /**
     * Constructs a ShuffleIterator for the given array of songs.
     * The songs are cloned and shuffled to preserve the original order.
     *
     * @param songs 
     */
    public ShuffleIterator(Song[] songs) {
        this.songs = songs.clone();
        this.rand = new Random();
        shuffleInPlace(this.songs);
        this.position = 0;
    }

    /**
     * Checks if there are more shuffled songs left to play.
     *
     * @return 
     */
    @Override
    public boolean hasNext() {
        return position < songs.length;
    }

    /**
     * Returns the next song in the shuffled order.
     *
     * @return 
     * @throws NoSuchElementException
     */
    @Override
    public Song next() {
        if (!hasNext()) throw new NoSuchElementException("No more songs (shuffled).");
        return songs[position++];
    }

    /**
     * Shuffles the given array of songs in place using the Fisher–Yates algorithm.
     *
     * @param arr the array of songs to shuffle
     */
    private void shuffleInPlace(Song[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Song tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
