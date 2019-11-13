package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/11/1
 */
public class ShortestDistanceToAChar {
    public static void main(String[] args) {
        int[] res = new ShortestDistanceToAChar().shortestToChar("loveleetcode", 'e');
        System.out.println(res[0]);
    }

    /**
     * O(N^2) 不太好
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {


            if (i == 0) {
                res[i] = S.indexOf(C);
            } else if (i == S.length() - 1){
                res[i] = i - S.lastIndexOf(C, i);
            } else {
                int backward = S.lastIndexOf(C, i) < 0 ? Integer.MAX_VALUE:i - S.lastIndexOf(C, i);
                int forward = S.indexOf(C, i) < 0 ? Integer.MAX_VALUE : S.indexOf(C, i) - i;
                res[i] = Math.min(backward, forward);
            }
        }
        return res;
    }

    /**
     * O（N）
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar1(String S, char C) {
        int[] res = new int[S.length()];
        int prev = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                prev = i;
                res[i] = 0;
            } else {
                if (prev == -1) {
                    res[i] = Integer.MAX_VALUE;
                } else {
                    res[i] = i - prev;
                }
            }
        }

        prev = -1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
                res[i] = 0;
            } else {
                res[i] = Math.min(res[i], prev==-1?Integer.MAX_VALUE:prev - i);
            }
        }

        return res;
    }

}
