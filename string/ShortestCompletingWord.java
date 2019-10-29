package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/10/28
 */
public class ShortestCompletingWord {
    /**
     * 找到最短的一个单词，使用了licensePlate全部的可用字符
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = null;
        for (String word : words) {
            if (check(licensePlate, word)) {
                if (res == null || word.length() < res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private boolean check(String license, String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }

        for (char c : license.toCharArray()) {
            if (Character.isAlphabetic(c) && --count[Character.toLowerCase(c) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
