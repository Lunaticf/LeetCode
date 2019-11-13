package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/10/31
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        // good number的意思是旋转每一位后得到的数与原来的数不同

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (checkGoodNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkGoodNumber(int i) {
        // 0 1 8 旋转到自己
        // 2 5 6 9 之外的数字旋转后都无效
        String s = String.valueOf(i);
        boolean flag = false;
        for (char c: s.toCharArray()) {
            if (c == '2' || c == '5' || c == '6' || c== '9') {
                flag = true;
            } else if (c == '3' || c == '4' || c == '7') {
                return false;
            }
        }
        return flag;
    }
}
