package Explanations; // Defines the package where this class belongs

import java.util.HashMap; // Importing HashMap for key-value storage
import java.util.Map; // Importing Map interface for defining mappings

// This class is responsible for handling Morse code conversions
public class MorseLogic {
    // Static HashMaps to store the mappings for Morse code conversions
    // "static" means these maps belong to the class itself, not instances of the class
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    private static final Map<String, Character> morseToEnglish = new HashMap<>();

    // Static block initializes the mappings once when the class is loaded
    static {
        // Mapping English and Swedish letters to Morse code
        englishToMorse.put('A', ".-"); englishToMorse.put('B', "-..."); englishToMorse.put('C', "-.-.");
        englishToMorse.put('D', "-.."); englishToMorse.put('E', "."); englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--."); englishToMorse.put('H', "...."); englishToMorse.put('I', "..");
        englishToMorse.put('J', ".---"); englishToMorse.put('K', "-.-"); englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--"); englishToMorse.put('N', "-."); englishToMorse.put('O', "---");
        englishToMorse.put('P', ".--."); englishToMorse.put('Q', "--.-"); englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "..."); englishToMorse.put('T', "-"); englishToMorse.put('U', "..-");
        englishToMorse.put('V', "...-"); englishToMorse.put('W', ".--"); englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--"); englishToMorse.put('Z', "--..");

        // Swedish Letters
        englishToMorse.put('Å', ".--.-"); englishToMorse.put('Ä', ".-.-"); englishToMorse.put('Ö', "---.");
        englishToMorse.put('å', ".--.-"); englishToMorse.put('ä', ".-.-"); englishToMorse.put('ö', "---.");


        // Special Characters & Punctuation
        englishToMorse.put('.', ".-.-.-"); englishToMorse.put(',', "--..--"); englishToMorse.put('?', "..--..");
        englishToMorse.put('!', "-.-.--"); englishToMorse.put(':', "---..."); englishToMorse.put(';', "-.-.-.");
        englishToMorse.put('(', "-.--."); englishToMorse.put(')', "-.--.-"); englishToMorse.put('&', ".-...");
        englishToMorse.put('@', ".--.-."); englishToMorse.put('=', "-...-"); englishToMorse.put('+', ".-.-.");
        englishToMorse.put('-', "-....-"); englishToMorse.put('_', "..--.-"); englishToMorse.put('$', "...-..-");
        englishToMorse.put('"', ".-..-."); englishToMorse.put('\'', ".----."); englishToMorse.put('%', "-----.-");

        // Reverse mapping from Morse to English/Swedish
        for (Map.Entry<Character, String> entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }

    // Method to convert English/Swedish text to Morse code
    public String englishToMorse(String englishText) {
        if (englishText == null || englishText.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty or just whitespace");
        }

        englishText = englishText.toUpperCase(); // Convert input to uppercase
        StringBuilder morseText = new StringBuilder(); // Efficiently build output

        for (char c : englishText.toCharArray()) {
            if (englishToMorse.containsKey(c)) {
                morseText.append(englishToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morseText.append("/ "); // Word separator in Morse code
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        return morseText.toString().trim();
    }

    // Method to convert Morse code to English/Swedish text
    public String morseToEnglish(String morseCode) {
        if (morseCode == null || morseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty or just whitespace");
        }

        StringBuilder englishText = new StringBuilder();
        String[] words = morseCode.split(" "); // Splitting Morse by spaces

        for (String word : words) {
            if (word.equals("/")) {
                englishText.append(" "); // Convert Morse separator back to space
            } else if (morseToEnglish.containsKey(word)) {
                englishText.append(morseToEnglish.get(word));
            } else {
                throw new IllegalArgumentException("Invalid Morse code: " + word);
            }
        }
        return englishText.toString();
    }
}
