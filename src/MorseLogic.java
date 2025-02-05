import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Logic class for Morse Code Conversion
public class MorseLogic {
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    private static final Map<String, Character> morseToEnglish = new HashMap<>();

    static {
        englishToMorse.put('A', ".-"); englishToMorse.put('B', "-..."); englishToMorse.put('C', "-.-.");
        englishToMorse.put('D', "-.."); englishToMorse.put('E', "."); englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--."); englishToMorse.put('H', "...."); englishToMorse.put('I', "..");
        englishToMorse.put('J', ".---"); englishToMorse.put('K', "-.-"); englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--"); englishToMorse.put('N', "-."); englishToMorse.put('O', "---");
        englishToMorse.put('P', ".--."); englishToMorse.put('Q', "--.-"); englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "..."); englishToMorse.put('T', "-"); englishToMorse.put('U', "..-");
        englishToMorse.put('V', "...-"); englishToMorse.put('W', ".--"); englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--"); englishToMorse.put('Z', "--..");
        englishToMorse.put('0', "-----"); englishToMorse.put('1', ".----"); englishToMorse.put('2', "..---");
        englishToMorse.put('3', "...--"); englishToMorse.put('4', "....-"); englishToMorse.put('5', ".....");
        englishToMorse.put('6', "-...."); englishToMorse.put('7', "--..."); englishToMorse.put('8', "---..");
        englishToMorse.put('9', "----.");
        englishToMorse.put(' ', "/"); // Space handling

        for (Map.Entry<Character, String> entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }
