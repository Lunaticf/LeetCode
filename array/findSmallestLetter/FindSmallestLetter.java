package leetCode.array.findSmallestLetter;

/**
 * @Author Lunaticf
 * @Date 2019/10/23
 */
public class FindSmallestLetter {
    /**
     * O(N)
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        // letters是有序的
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    /**
     * 二分搜索
     * 定位到target应该插入的位置
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter1(char[] letters, char target) {
        int i = 0;
        int j = letters.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // i定位到了target应该插入的位置
        return i == letters.length ? letters[0] : letters[i];
    }
}
