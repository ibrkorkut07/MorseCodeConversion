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
            logic.englishToMorse("HELLO!");
        });
        assertTrue(exception.getMessage().contains("Invalid character"));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            logic.morseToEnglish(".... . .-.. .-.. --- .-.-.-");
        });
        assertTrue(exception.getMessage().contains("Invalid Morse code"));
    }

    @Test
    public void testEmptyInput() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            logic.englishToMorse("");
        });
        assertTrue(exception1.getMessage().contains("Input cannot be empty"));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            logic.morseToEnglish("");
        });
        assertTrue(exception2.getMessage().contains("Input cannot be empty"));
    }

    @Test
    public void testMorseToEnglishWithSpaces() {
        assertEquals("HELLO WORLD", logic.morseToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    public void testEnglishToMorseWithNumbers() {
        assertEquals(".---- ..--- ...--", logic.englishToMorse("123"));
    }
}
