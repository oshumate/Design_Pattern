package state;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DeliveryDriver {
	private static final String YES = "y";
    private static final String NO = "n";
    private Scanner reader;

	public DeliveryDriver() {
		reader = new Scanner(System.in);
	}

	public void run(){
		while(true) {
			clear();
			System.out.print("What would you like to order: ");
			Package item = new Package(reader.nextLine(), getNumItem());
			System.out.println("\nOrdering:\n" + item.order());
			sleep(5000);
			System.out.println("\nMailing:\n" + item.mail());
			sleep(5000);
			System.out.println("\nDelivery\n" + item.received());
			sleep(5000);

			if(!playAgain()) break;
		}
	}

	public int getNumItem(){
        while(true) {
            System.out.println("Enter quantity between 1 and 10: ");

            int number = Integer.parseInt(reader.nextLine());

            if(number < 1 || number > 10){
                System.out.println("Not a valid choice.");
                continue;
            }

			return number;
		}
	}

	/**
     * Asks the user if they would like to continue
     * If they enter yes, it returns true, otherwise it returns false
     * 
     * @return True if they want to play again, and false otherwise
     */
    private boolean playAgain() {
        while (true) {
            System.out.print("Do you want to continue (Y)es or (N)o: ");
            String command = reader.nextLine().toLowerCase().trim();

            if (command.equals(YES)) {
                return true;
            } else if (command.equals(NO)) {
                return false;
            } else {
                System.out.println("Sorry, that's not a valid command");
            }
        }
    }

	/**
     * Pauses the program
     * 
     * @param num The miliseconds to pause the program for
     */
    public static void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

    /**
     * Clears the console
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
    }

	public static void main(String[] args) {
		(new DeliveryDriver()).run();
	}
}
