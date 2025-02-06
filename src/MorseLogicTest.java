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




}

