import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseLogic logic = new MorseLogic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to convert English/Swedish to Morse code");
        System.out.println("Enter 2 to convert Morse code to English/Swedish");

        int choice;
        while (true) {
            System.out.print("Enter your choice (1 or 2): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next();
            }
        }

        while (true) {
            try {
                if (choice == 1) {
                    System.out.println("Enter English/Swedish text:");
                    String englishText = scanner.nextLine();
                    String morseCode = logic.englishToMorse(englishText);
                    System.out.println("Morse code: " + morseCode);
                    break;
                } else if (choice == 2) {
                    System.out.println("Enter Morse code (separate letters with spaces, words with /):");
                    String morseCode = scanner.nextLine();
                    String englishText = logic.morseToEnglish(morseCode);
                    System.out.println("The text: " + englishText);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }
}
