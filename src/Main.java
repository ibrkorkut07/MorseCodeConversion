package Explanations;

import java.util.Scanner; // Importing Scanner class for user input

// Main class responsible for user interaction
public class Main {
    public static void main(String[] args) {
        MorseLogic logic = new MorseLogic(); // Creating an instance of MorseLogic to access conversion methods
        Scanner scanner = new Scanner(System.in); // Scanner object for reading user input

        // Displaying menu options for the user
        System.out.println("Enter 1 to convert English/Swedish to Morse code");
        System.out.println("Enter 2 to convert Morse code to English/Swedish");

        int choice;
        while (true) { // Loop to validate user input
            System.out.print("Enter your choice (1 or 2): ");
            if (scanner.hasNextInt()) { // Check if input is an integer
                choice = scanner.nextInt(); // Read integer input
                scanner.nextLine(); // Consume the newline character to prevent issues with nextLine()
                if (choice == 1 || choice == 2) {
                    break; // Exit loop if input is valid
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }

        while (true) { // Loop to ensure valid text input and handle errors
            try {
                if (choice == 1) { // If user selects text-to-Morse conversion
                    System.out.println("Enter English/Swedish text:");
                    String englishText = scanner.nextLine(); // Read text input
                    String morseCode = logic.englishToMorse(englishText); // Convert text to Morse code
                    System.out.println("Morse code: " + morseCode); // Display converted Morse code
                    break;
                } else if (choice == 2) { // If user selects Morse-to-text conversion
                    System.out.println("Enter Morse code (separate letters with spaces, words with /):");
                    String morseCode = scanner.nextLine(); // Read Morse code input
                    String englishText = logic.morseToEnglish(morseCode); // Convert Morse code to text
                    System.out.println("The text: " + englishText); // Display converted text
                    break;
                }
            } catch (IllegalArgumentException e) { // Catch any conversion errors
                System.out.println("Error: " + e.getMessage()); // Print error message
                System.out.println("Please try again."); // Prompt user to retry input
            }
        }

        scanner.close(); // Close scanner to prevent memory leaks
    }
}
