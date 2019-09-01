package leetCode.hashTable.firstUniqueCharacterInAString;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        new FirstUniqueCharacterInAString().firstUniqChar("aleetcode");
    }

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }

        for (int i =  0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
     }

    public int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;

            }
        }
        return -1;
    }
}
