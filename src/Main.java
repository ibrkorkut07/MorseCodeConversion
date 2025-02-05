import java.util.Scanner;
// Main class for user interaction
public class Main {
    public static void main(String[] args) {
        MorseLogic logic = new MorseLogic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to convert English to Morse code");
        System.out.println("Enter 2 to convert Morse code to English");
        int choice;
        while (true) {
            System.out.print("Enter your choice (1 or 2): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine();

        while (true) {
            try {
                if (choice == 1) {
                    System.out.println("Enter English text:");
                    String englishText = scanner.nextLine();
                    String morseCode = logic.englishToMorse(englishText);
                    System.out.println("Morse code: " + morseCode);
                    break;
                } else if (choice == 2) {
                    System.out.println("Enter Morse code (separate letters with spaces, words with /):");
                    String morseCode = scanner.nextLine();
                    String englishText = logic.morseToEnglish(morseCode);
                    System.out.println("English text: " + englishText);
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            } finally {
                scanner.close();
            }
        }
    }
}