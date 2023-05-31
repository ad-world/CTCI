import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Arrays {
    // 1.1 Is Unique
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

    // 1.2 Check Permutation
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

    // 1.3 URLify
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

    // 1.4 Palindrome Permutation
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

    // 1.5 Edit Distance
    public boolean editDistance(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1) return false;

        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;

        int i = 0; // index for longer string
        int j = 0; // index for shorter string

        boolean found = false;
        while(i < longer.length() && j < shorter.length()) {
            if(longer.charAt(i) != shorter.charAt(j)) {
                // if we find a difference
                if(found) return false; // difference already found, return false
                found = true; // otherwise, set to true for next time

                if(shorter.length() == longer.length()) { // this means we are on replacement
                    j++; // add one to shorter index (since we already add one to longer one at the end)
                }
            } else {
                j++; // add one to shorter index
            }
            i++; // always add one to longer index
        }
        return  true;
    }

    // 1.6 String Compression
    public String stringCompression(String s) {
        int i = 0, j = 0;
        char current = s.charAt(0);

        StringBuilder builder = new StringBuilder();

        while(j != s.length()) {
            if(s.charAt(j) == current) {
                if(j == s.length() - 1) {
                    int length = j - i + 1;
                    builder.append(current).append(length);
                }
                j++;
            } else {
                int length = j - i;
                builder.append(current).append(length);
                i = j;
                current = s.charAt(j);
            }
        }

        String result = builder.toString();

        if (result.length() >= s.length()) {
            return s;
        } else {
            return result;
        }
    }

    // 1.7 Rotate Matrix
    public boolean rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        for(int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                int top = matrix[layer][i];

                matrix[layer][i] = matrix[last-offset][layer];
                matrix[last-offset][layer] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return true;
    }

    // 1.8 Zero Matrix
    public int[][] zeroMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return matrix;
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    emptyX.add(i);
                }
            }
        }

        for(int x: emptyX) {
            for(int j = 0; j < m; j++) {
                matrix[x][j] = 0;
            }
            for(int i = 0; i < n; i++) {
                matrix[i][x] = 0;
            }
        }

        return matrix;
    }

    // 1.9 String Rotation
    public boolean isRotation(String s1, String s2) {
        int s1length = s1.length();
        int s2length = s2.length();

        if(s1length == s2length && s1length > 0) {
            String doubleS1 = s1+s1;
            return isSubstring(doubleS1, s2);
        }

        return false;
    }

    /*
    Helper function for isRotation. Spec of question requires to implement isRotation with only one
    call to isSubstring
     */
    private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}