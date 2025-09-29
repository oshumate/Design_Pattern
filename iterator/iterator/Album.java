//Owen Shumate
package iterator;

import java.util.Iterator;

/**
 * Represents a music album containing a collection of songs.
 * Provides methods to add songs to play them
 * in order or shuffled.
 * 
 */
public class Album {
    /** Array of songs in the album. */
    private Song[] songs;

    /** Current number of songs in the album. */
    private int count;

    /** Name of the album. */
    private final String name;

    /**
     * Constructs an Album with the given name.
     *
     * @param name the name of the album
     */
    public Album(String name) {
        this.name = name;
        this.songs = new Song[10];
        this.count = 0;
    }

    /**
     * Returns the name of the album.
     *
     * @return the album name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a new song to the album.
     *
     * @param name   the song title
     * @param artist the song artist
     * @param length the song length in minutes
     * @param genre  the song genre
     * @return true if the song was added successfully
     */
    public boolean addSong(String name, String artist, double length, Genre genre) {
        ensureCapacity(count + 1);
        songs[count++] = new Song(name, artist, length, genre);
        return true;
    }

    /**
     * Creates an iterator to play the songs in order.
     *
     * @return an iterator for ordered playback
     */
    public Iterator<Song> createInOrderIterator() {
        Song[] copy = new Song[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return new InOrderIterator(copy);
    }

    /**
     * Creates an iterator to play the songs in random order.
     *
     * @return an iterator for shuffled playback
     */
    public Iterator<Song> createShuffleIterator() {
        Song[] copy = new Song[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return new ShuffleIterator(copy);
    }

    /**
     * Ensures the internal array has enough capacity for new songs.
     *
     * @param minCapacity the required minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= songs.length) return;
        int newCap = Math.max(songs.length * 2, minCapacity);
        Song[] bigger = new Song[newCap];
        System.arraycopy(songs, 0, bigger, 0, count);
        songs = bigger;
    }
}
