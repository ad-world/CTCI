public class TestSuite {
    public <T> void test(T value, T expected) {
        if(value.equals(expected)) {
            System.out.println("Test passed.");
            return;
        }

        System.out.println("Test failed.");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + value);
    }

}
