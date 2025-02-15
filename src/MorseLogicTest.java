
import org.junit.jupiter.api.Test; // Importing JUnit for unit testing
import static org.junit.jupiter.api.Assertions.*; // Importing assertion methods for test validation

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
        // Testing conversion of Morse code to English words
        assertEquals("HELLO", logic.morseToEnglish(".... . .-.. .-.. ---"));
        assertEquals("WORLD", logic.morseToEnglish(".-- --- .-. .-.. -.."));
        assertEquals("HELLO WORLD", logic.morseToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    public void testInvalidEnglishCharacter() {
        try {
            logic.englishToMorse("HELLO#");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException exception) {
            assertTrue(exception.getMessage().contains("Invalid character"));
        }
    }

    @Test
    public void testInvalidMorseCode() {
        try {
            logic.morseToEnglish(".... . .-.. .-.. --- ..--.-.-");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException exception) {
            assertTrue(exception.getMessage().contains("Invalid Morse code"));
        }
    }

    @Test
    public void testEmptyInput() {
        try {
            logic.englishToMorse("");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Input cannot be empty or just whitespace", exception.getMessage());
        }
    }

    @Test
    public void testSpecialCharactersToMorse() {
        assertEquals(".--.-. ..--.. -.-.--", logic.englishToMorse("@?!"));
        assertEquals("-...- .-.-.- --..--", logic.englishToMorse("=.,"));
    }

    @Test
    public void testSwedishLettersToMorse() {
        assertEquals(".--.- .-.- ---.", logic.englishToMorse("ÅÄÖ"));
        assertEquals(".--.- .-.- ---.", logic.englishToMorse("åäö"));
    }
}
