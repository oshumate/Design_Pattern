package singleton;

/**
 * A Song has a title, artist, and a file path that can be played.
 * Author: Owen Shumate
 */
public class Song {
    private String title;
    private String artist;
    private String filePath;

    /**
     * Makes a Song with title, artist, and file name.
     * @param title  
     * @param artist 
     * @param fileName 
     */
    public Song(String title, String artist, String fileName) {
        this.title = title;
        this.artist = artist;
        this.filePath = fileName;
    }

    /**
     * Get the file path for the song.
     * @return the file path string
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Turn the song into a string.
     * @return title and artist
     */
    public String toString() {
        return title + " by " + artist;
    }

    /**
     * Play this song using SongPlayer.
     */
    public void play() {
        SongPlayer.play(filePath);
    }
}
