package singleton;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Owen Shumate
 */
public class DataLoader {

    /**
     * Reads songs from songs.txt and returns them in a list.
     *
     * @return an ArrayList of Songs
     */
    public static ArrayList<Song> getSongs() {
        ArrayList<Song> list = new ArrayList<Song>();

        File listing = locateSongsTxt();
        if (listing == null || !listing.exists()) {
            System.out.println("could not read songs.txt");
            return list;
        }

        try (Scanner sc = new Scanner(listing, "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue; // skip blank lines or comments
                }

                String[] p = line.split(",");
                if (p.length < 3) {
                    continue; // skip bad lines
                }

                String title = p[0].trim();
                String artist = p[1].trim();
                String nameOrPath = p[2].trim();

                // figure out the path
                String resolved = resolvePath(nameOrPath);
                list.add(new Song(title, artist, resolved));
            }
        } catch (Exception e) {
            System.out.println("could not read songs.txt");
        }

        return list;
    }

    /**
     * Finds path to song file
     *
     * @param nameOrPath the file name from songs.txt
     * @return a resolved file path string
     */
    private static String resolvePath(String nameOrPath) {
        File f = new File(nameOrPath);
        boolean hasSlash = nameOrPath.contains("/") || nameOrPath.contains("\\");
        if (f.isAbsolute() || hasSlash) {
            return nameOrPath; // user already gave a folder or absolute path
        }


        //Try singleton/songs/<file>
        File c2 = new File("singleton" + File.separator + "songs", nameOrPath);
        if (c2.exists()) return c2.getPath();
        // Not found, just return as-is
        return nameOrPath;
    }

    /**
     * Attempts to find songs.txt
     *
     * @return a File object for songs.txt
     */
    private static File locateSongsTxt() {


        File f1 = new File("singleton" + File.separator + "songs.txt");
        if (f1.exists()) return f1;


        return null;
    }
}
