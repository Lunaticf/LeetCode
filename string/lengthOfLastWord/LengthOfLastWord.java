package LeetCode.string.lengthOfLastWord;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        return ss.length > 0 ? ss[ss.length - 1].length() : 0;
    }

    public int lengthOfLastWord1(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }

    // 最直白的方法
    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }

}
