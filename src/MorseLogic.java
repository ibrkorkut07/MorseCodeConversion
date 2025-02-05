import java.util.HashMap;
import java.util.Map;

public class MorseLogic {
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    private static final Map<String, Character> morseToEnglish = new HashMap<>();

    static {
        // Letters
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

        // Numbers
        englishToMorse.put('0', "-----"); englishToMorse.put('1', ".----"); englishToMorse.put('2', "..---");
        englishToMorse.put('3', "...--"); englishToMorse.put('4', "....-"); englishToMorse.put('5', ".....");
        englishToMorse.put('6', "-...."); englishToMorse.put('7', "--..."); englishToMorse.put('8', "---..");
        englishToMorse.put('9', "----.");

        // Special Characters & Punctuation
        englishToMorse.put('.', ".-.-.-"); englishToMorse.put(',', "--..--"); englishToMorse.put('?', "..--..");
        englishToMorse.put('!', "-.-.--"); englishToMorse.put(':', "---..."); englishToMorse.put(';', "-.-.-.");
        englishToMorse.put('(', "-.--."); englishToMorse.put(')', "-.--.-"); englishToMorse.put('&', ".-...");
        englishToMorse.put('@', ".--.-."); englishToMorse.put('=', "-...-"); englishToMorse.put('+', ".-.-.");
        englishToMorse.put('-', "-....-"); englishToMorse.put('_', "..--.-"); englishToMorse.put('$', "...-..-");
        englishToMorse.put('"', ".-..-."); englishToMorse.put('\'', ".----."); englishToMorse.put('%', "-----.-");

        // Reverse map for Morse to English conversion
        for (Map.Entry<Character, String> entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }

    public String englishToMorse(String englishText) {
        if (englishText == null || englishText.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty or just whitespace");
        }

        StringBuilder morseText = new StringBuilder();
        for (char c : englishText.toCharArray()) {
            if (englishToMorse.containsKey(c)) {
                morseText.append(englishToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morseText.append("/ "); // Space between words in Morse
            } else {
                throw new IllegalArgumentException("Invalid character: " + c); // Ensure exception is thrown
            }
        }
        return morseText.toString().trim();
    }

    public String morseToEnglish(String morseCode) {
        if (morseCode == null || morseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty or just whitespace");
        }

        StringBuilder englishText = new StringBuilder();
        String[] words = morseCode.split(" ");
        for (String word : words) {
            if (word.equals("/")) {
                englishText.append(" ");
            } else if (morseToEnglish.containsKey(word)) {
                englishText.append(morseToEnglish.get(word));
            } else {
                throw new IllegalArgumentException("Invalid Morse code: " + word); // Ensure exception is thrown
            }
        }
        return englishText.toString(); // Preserve original case
    }
}
