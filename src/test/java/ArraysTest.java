import org.junit.jupiter.api.Test;

import java.sql.Array;

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
    public void palindromePermutationTest() {
        boolean test1 = arrayProblems.palindromePermutation("Tact Coa");
        boolean test2 = arrayProblems.palindromePermutation("aryaman");
        boolean test3 = arrayProblems.palindromePermutation("aacdrbrdcaa");
        boolean test4 = arrayProblems.palindromePermutation("abacabaac");

        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
        assertTrue(test4);
    }

    @Test
    public void editDistanceTest() {
        boolean test1 = arrayProblems.editDistance("Arya", "Aryam");
        boolean test2 = arrayProblems.editDistance("hello", "world");
        boolean test3 = arrayProblems.editDistance("pale", "bale");

        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
    }

    @Test
    public void stringCompressionTest() {
        String test1 = arrayProblems.stringCompression("aabcccccaaa");
        String test2 = arrayProblems.stringCompression("aryaman");
        String test3 = arrayProblems.stringCompression("aaaahhhhhhhwweer");

        assertEquals("a2b1c5a3", test1);
        assertEquals("aryaman", test2);
        assertEquals("a4h7w2e2r1", test3);
    }

    @Test
    public void rotateMatrixTest() {
        int[][] arr1 = {{0,0}, {1,2}};
        int[][] arr2 = {{1, 2, 3, 4, 5}};

        boolean test1 = arrayProblems.rotate(arr1);
        boolean test2 = arrayProblems.rotate(arr2);

        assertTrue(test1);
        assertFalse(test2);
    }

    @Test
    public void zeroMatrixTest() {
        int[][] arr1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] arr2 = {{0, 3}, {2, 3}, {3, 4}};
        int[][] res1 = arrayProblems.zeroMatrix(arr1);
        int[][] res2 = arrayProblems.zeroMatrix(arr2);

        assertArrayEquals(new int[][] {{1, 1}, {2, 2}, {3, 3}}, res1);
        assertArrayEquals(new int[][] {{0, 0}, {0, 3}, {0, 4}}, res2);
    }

    @Test
    public void isRotationTest() {
        assertTrue(arrayProblems.isRotation("waterbottle", "erbottlewat"));
        assertFalse(arrayProblems.isRotation("aryaman", "dhingra"));
        assertFalse(arrayProblems.isRotation("", "123"));
        assertTrue(arrayProblems.isRotation("rotation", "tionrota"));
    }
}