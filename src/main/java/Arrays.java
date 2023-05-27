import java.util.Hashtable;

public class Arrays {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        // 1. isUnique
        suite.test(isUnique("aryaman"), false);
        suite.test(isUnique("abcde"), true);
        suite.test(isUnique(""), true);


        // 2. checkPermutation
        suite.test(checkPermutation("1234", "2431"), true);
        suite.test(checkPermutation("Aryaman", "Pooja"), false);
        suite.test(checkPermutation("", " "), false);

        // 3. URLify
        suite.test(URLify("This is a test      ".toCharArray(), 14), "This%20is%20a%20test");
        suite.test(URLify("Lots   of   spaces            ".toCharArray(),  18), "Lots%20%20%20of%20%20%20spaces");

    }

    public static boolean isUnique(String s) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(hashtable.containsKey(c)) {
                return false;
            }

            hashtable.put(c, 1);
        }

        return true;
    }

    public static boolean checkPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        java.util.Arrays.sort(s1arr);
        java.util.Arrays.sort(s2arr);

        String news1 = String.valueOf(s1arr);
        String news2 = String.valueOf(s2arr);

        return news1.equals(news2);
    }

    public static String URLify(char[] string, int trueLength) {
        int spaces = 0;
        for(int i = 0; i < trueLength; i++) {
            if(string[i] == ' ') spaces++;
        }

        int index = trueLength + spaces * 2;
        if(trueLength < string.length) string[trueLength] = '\0';

        for(int i = trueLength - 1; i >= 0; i--) {
            if(string[i] == ' ') {
                string[index - 1] = '0';
                string[index - 2] = '2';
                string[index - 3] = '%';
                index = index - 3;
            } else {
                string[index - 1] = string[i];
                index--;
            }
        }

        return String.valueOf(string);
    }

}
