import java.util.HashMap;
import java.util.Hashtable;

public class Arrays {
    public boolean isUnique(String s) {
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

    public boolean checkPermutation(String s1, String s2) {
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

    public String URLify(char[] string, int trueLength) {
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

    public boolean palindromePermutation(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        s = s.toLowerCase();
        int charCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                charCount++;
                if(hashMap.containsKey(s.charAt(i))) {
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
                } else {
                    hashMap.put(s.charAt(i), 1);
                }
            }
        }



        if(charCount % 2 == 0) {
            for(Integer value : hashMap.values()) {
                if(value % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            int countOdd = 0;
            for(Integer value : hashMap.values()) {
                if(value % 2 == 1) {
                    countOdd++;
                }
            }

            return countOdd == 1;
        }
    }
}