package iterator;

import java.util.Scanner;
import java.util.Iterator;

public class SongDriver {
	private Scanner reader;

	public SongDriver() {
		reader = new Scanner(System.in);
	}

	public void run() {
		clear();
		System.out.println("*** Welcome to our Album Player ***");
		Album album = makeAlbum();
		Iterator<Song> albumIterator = getAlbumIterator(album);
		int counter = 1;

		clear();
		System.out.println("Album: " + album.getName());
		while(albumIterator.hasNext()){
			System.out.println(counter + ". " + albumIterator.next());
			counter++;
		}
	}

	public Iterator<Song> getAlbumIterator(Album album) {
		while(true){
			System.out.println("How would you like to play your songs:");
			System.out.println("1. In order");
			System.out.println("2. Shuffle");

			int choice = Integer.parseInt(reader.nextLine());

			if(choice == 1){
				return album.createInOrderIterator();
			} else if(choice == 2){
				return album.createShuffleIterator();
			} else {
				System.out.println("Not a valid choice");
				continue;
			}
		}
	}

	public Album makeAlbum() {
		Album album = new Album("Surfer Girl");
		album.addSong("Surfer Girl", "The Beach Boys", 2.26, Genre.Pop);
		album.addSong("Catch a Wave", "The Beach Boys", 2.07, Genre.Pop);
		album.addSong("The Surfer Moon", "The Beach Boys", 2.11, Genre.Pop);
		album.addSong("South Bay Surfer", "The Beach Boys", 1.45, Genre.Pop);
		album.addSong("The Rocking Surfer", "The Beach Boys", 2, Genre.Pop);
		album.addSong("Little Deuce Coupe", "The Beach Boys", 1.38, Genre.Pop);
		album.addSong("In My Rooom", "The Beach Boys", 2.11, Genre.Pop);
		album.addSong("Hawaii", "The Beach Boys", 1.59, Genre.Pop);
		album.addSong("Surfers Rule", "The Beach Boys", 1.54, Genre.Pop);
		album.addSong("Our Car Club", "The Beach Boys", 2.22, Genre.Pop);
		album.addSong("Your Summer Dream", "The Beach Boys", 2.27, Genre.Pop);
		album.addSong("Boogie Woodie", "The Beach Boys", 1.56, Genre.Pop);

		return album;
	}

	/**
     * Clears the console
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
    }

	public static void main(String[] args) {
		(new SongDriver()).run();
	}
}
