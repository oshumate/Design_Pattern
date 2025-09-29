//Owen Shumate
package iterator;

/**
 * Represents a song with a title, artist, length, and genre.
 */
public class Song {
    /** Title of the song. */
    private final String name;

    /** Artist  */
    private final String artist;

    /** Length of the song in minutes. */
    private final double length;

    /** Genre of the song. */
    private final Genre genre;

    /**
     * Constructs a Song with the given details.
     *
     * @param name   
     * @param artist 
     * @param length 
     * @param genre  
     */
    public Song(String name, String artist, double length, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.genre = genre;
    }

    /**
     * Returns a string of the song 
     *
     * @return formatted song details
     */
    @Override
    public String toString() {
        return String.format("%s by %s (%.2f min, %s)", name, artist, length, genre);
    }

    /**
     * Returns the song title.
     *
     * @return the song name
     */
    public String getName() { return name; }

    /**
     * Returns the song artist.
     *
     * @return the artist name
     */
    public String getArtist() { return artist; }

    /**
     * Returns the song length in minutes.
     *
     * @return the song length
     */
    public double getLength() { return length; }

    /**
     * Returns the song genre.
     *
     * @return the genre
     */
    public Genre getGenre() { return genre; }
}
