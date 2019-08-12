package LeetCode.string.countAndSay;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        String s = "1";
        int i = 1;
        while (i++ < n) {
            s = count(s);
        }
        return s;
    }

    // 返回countAndSay一次的值
    private static String count(String s) {
        StringBuilder temp = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                temp.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        temp.append(count).append(c);
        return temp.toString();
    }
}
