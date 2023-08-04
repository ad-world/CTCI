import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExtrasTest {

    Extras extras = new Extras();

    @Test
    public void normalizeWhiteSpaceTest() {
        String s = "Hello \t \t  my     \n name \n \n is aryama\t n";
        assertEquals("Hello my name is aryama n", extras.normalizeWhiteSpace(s));
    }
}
