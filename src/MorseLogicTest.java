import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseLogicTest {
    private final MorseLogic logic = new MorseLogic();

    @Test
    public void testEnglishToMorse() {
        assertEquals(".... . .-.. .-.. ---", logic.englishToMorse("HELLO"));
        assertEquals(".-- --- .-. .-.. -..", logic.englishToMorse("WORLD"));
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", logic.englishToMorse("HELLO WORLD"));
    }

    @Test
    public void testMorseToEnglish() {
        assertEquals("HELLO", logic.morseToEnglish(".... . .-.. .-.. ---"));
        assertEquals("WORLD", logic.morseToEnglish(".-- --- .-. .-.. -.."));
        assertEquals("HELLO WORLD", logic.morseToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    public void testInvalidEnglishCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            logic.englishToMorse("HELLO#"); // Invalid character
        });
        assertTrue(exception.getMessage().contains("Invalid character"));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            logic.morseToEnglish(".... . .-.. .-.. --- ..--.-.-"); // Completely invalid Morse sequence
        });
        assertTrue(exception.getMessage().contains("Invalid Morse code"));
    }

    @Test
    public void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            logic.englishToMorse("");
        });
        assertEquals("Input cannot be empty or just whitespace", exception.getMessage());
    }
}
