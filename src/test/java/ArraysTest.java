import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    Arrays arrayProblems = new Arrays();

    @Test
    public void isUniqueTest() {
        boolean test1 = arrayProblems.isUnique("aryaman");
        boolean test2 = arrayProblems.isUnique("abcde");
        boolean test3 = arrayProblems.isUnique("");

        assertFalse(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    public void checkPermutationTest() {
        boolean test1 = arrayProblems.checkPermutation("1234", "2431");
        boolean test2 = arrayProblems.checkPermutation("Aryaman", "Pooja");
        boolean test3 = arrayProblems.checkPermutation("", " ");

        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);
    }

    @Test
    public void URLifyTest() {
        String test1 = arrayProblems.URLify("This is a test      ".toCharArray(), 14);
        String test2 = arrayProblems.URLify("Lots   of   spaces            ".toCharArray(), 18);

        assertEquals(test1, "This%20is%20a%20test");
        assertEquals(test2, "Lots%20%20%20of%20%20%20spaces");
    }

    @Test
    public void palindomePermutationTest() {
        boolean test1 = arrayProblems.palindromePermutation("Tact Coa");
        boolean test2 = arrayProblems.palindromePermutation("aryaman");
        boolean test3 = arrayProblems.palindromePermutation("aacdrbrdcaa");
        boolean test4 = arrayProblems.palindromePermutation("abacabaac");

        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
        assertTrue(test4);
    }
}