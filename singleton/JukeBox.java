package singleton;

import java.util.ArrayList;

/**
 * JukeBox is a singleton that loads songs and lets you play them.
 * Author: Owen Shumate
 */
public class JukeBox {
    private static JukeBox jukeBox;
    private ArrayList<Song> songs;

    /**
     * Private constructor loads songs from DataLoader.
     */
    private JukeBox() {
        songs = DataLoader.getSongs();
        if (songs == null) {
            songs = new ArrayList<Song>();
        }
    }

    /**
     * Get the JukeBox instance.
     * @return the single JukeBox
     */
    public static JukeBox getInstance() {
        if (jukeBox == null) {
            jukeBox = new JukeBox();
        }
        return jukeBox;
    }

    /**
     * Get all of the songs
     * @return list of songs
     */
    public ArrayList<Song> getAllSongs() {
        return songs;
    }

    /**
     * Play a song by index.
     * @param num index of the song in the list
     */
    public void requestSong(int num) {
        if (num >= 0 && num < songs.size()) {
            Song s = songs.get(num);
            System.out.println("Now playing: " + s);
            System.out.println("[JukeBox] file path: " + s.getFilePath());
            s.play();
        } else {
            System.out.println("Invalid song number");
        }
    }
}
