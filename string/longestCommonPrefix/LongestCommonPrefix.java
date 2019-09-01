package leetCode.string.longestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flip", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // find shortest string
        String shortestStr = strs[0];
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        // process by shortest string
        boolean findPrefix = false;
        for (int i = shortestStr.length(); i >= 0; i--) {
            String temp = shortestStr.substring(0, i);
            findPrefix = true;
            for (String str : strs) {
                if (!str.startsWith(temp)) {
                    findPrefix = false;
                    break;
                }
            }
            if (findPrefix) {
                return temp;
            }
        }

        return "";
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.equals("")) {
                return "";
            }
        }
        return prefix;
    }

}
