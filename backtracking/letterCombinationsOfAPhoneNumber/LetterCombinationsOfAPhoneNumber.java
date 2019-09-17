package leetCode.backtracking.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/9/17
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        HashMap<Character, List<Character>> map= new HashMap<>(16);
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));


        dfs(res, 0, map, digits, new StringBuilder());


        return res;
    }

    private void dfs(List<String> res, int pos, HashMap<Character, List<Character>> map, String digits, StringBuilder s) {
        // 出口
        if (pos == digits.length()) {
            res.add(s.toString());
            return;
        }

        char c = digits.charAt(pos);
        for (char letter : map.get(c)) {
            dfs(res, pos + 1, map, digits, s.append(letter));
            s.deleteCharAt(s.length() - 1);
            // 或者每次新建一个字符串
//            dfs(res, pos + 1, map, digits, new StringBuilder(s.toString()).append(letter));
        }
    }
}
