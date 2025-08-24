package strategy;
import java.util.Scanner;

public class MedievalDriver {
    private static final String YES = "y";
    private static final String NO = "n";
    private Scanner reader;

    public MedievalDriver() {
        reader = new Scanner(System.in);
    }

    public void run(){
        while(true){
            Character character = getCharacter();
            Resources.clear();
            System.out.println(character);

            character.setWeaponBehavior(getWeaponBehavior());

            System.out.println("\nPress any key to attack...");
            reader.nextLine();
            character.attack();

            if(!playAgain())break;
        }

        System.out.println("Goodbye");
    }

    public WeaponBehavior getWeaponBehavior(){
        while(true) {
            System.out.println("Which weapon would you like: ");
            System.out.println("1. Bow");
            System.out.println("2. Knife");
            System.out.println("3. Throwing Stars");
            System.out.println("4. No Weapon");

            int number = Integer.parseInt(reader.nextLine());

            if(number < 1 || number > 4){
                System.out.println("Not a valid choice.");
                continue;
            }

            if(number ==1){
                return new WeaponBow();
            } else if(number == 2){
                return new WeaponKnife();
            } else  if(number == 3){
                return new WeaponStars();
            } else {
                return new WeaponNone();
            }
        }
    }

    public Character getCharacter() {
        while(true){
            System.out.println("Which character would you like to be: ");
            System.out.println("1. King");
            System.out.println("2. Knight");
            System.out.println("3. Troll");

            int number = Integer.parseInt(reader.nextLine());

            if(number < 1 || number > 3){
                System.out.println("Not a valid choice.");
                continue;
            }

            System.out.print("Enter your characters name: ");
            String characterName = reader.nextLine();

            if(number ==1){
                return new King(characterName);
            } else if(number == 2){
                return new Knight(characterName);
            } else {
                return new Troll(characterName);
            }
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

    public static void main(String[] args) {
        MedievalDriver driver = new MedievalDriver();
        driver.run();
    }
}