package leetCode.string.implementStrStr;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int needLen = needle.length();
        if (needLen == 0) {
            return 0;
        }

        int hayLen = haystack.length();
        for (int i = 0; i <= hayLen - needLen; i++) {
            if (haystack.substring(i, i + needLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
