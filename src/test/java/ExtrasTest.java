import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ExtrasTest {

    Extras extras = new Extras();

    @Test
    public void normalizeWhiteSpaceTest() {
        String s = "Hello \t \t  my     \n name \n \n is aryama\t n";
        assertEquals("Hello my name is aryama n", extras.normalizeWhiteSpace(s));
    }

    @Test
    public void wordBreakTest() {
        Extras.WordBreak word = new Extras().new WordBreak();
        String s = "hello \t \t auto \n     - mated \n how are you \t \t \t doing";
        assertEquals(new ArrayList<>(Arrays.asList("hello", "auto-", "mated", "how", "are", "you", "doing")), word.splitSentence(s, 10));

        String s2 = "arya -        man \n ama \t \t \n    - \t \t \n zing";
        assertEquals(new ArrayList<>(Arrays.asList("arya-", "man", "ama-", "zing")), word.splitSentence(s2, 6));
    }
}
