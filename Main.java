package leetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.next();
        // abbabbabb
        // 000000000
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            s.append("0");
        }

        // 先找s自己的循环节
        for (int i = 1; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                if (check(raw, i)) {
                    s.replace(i-1, i, "1");
                }
            }
        }

        // 再找其他的循环节
        // 先找s自己的循环节
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i) != '1') {
                // 构建一个包含s的前缀串




                String supply = raw + "";
                if (check(supply, i)) {
                    s.replace(i-1, i, "1");
                }
            }
        }

        System.out.println(s);
    }

    private static boolean check(String s, int num) {
        Set<String> set = new HashSet<>();

        // 每num个字符构成的字符串都是一样的
        for (int i = 0; i< s.length();i+=num) {
            String sub = s.substring(i, i+num);
            set.add(sub);
        }

        return set.size() == 1;
    }
}
