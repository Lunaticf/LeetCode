package leetCode.string.studentAttendanceRecord1;

/**
 * @Author Lunaticf
 * @Date 2019/10/15
 */
public class StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {
        // 一个学生收到奖励，当他的记录不包含多于一个的A
        // 或者不多于两个连续的L...划重点 连续的
        // 也就是要三个连续的L

        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }

    public boolean checkRecord1(String s) {
        // 直接遍历
        int A = 0, L = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                A++;
            }
            if (s.charAt(i) == 'L') {
                L++;
            } else {
                L = 0;
            }
            if (A >= 2 || L > 2) {
                return false;
            }
        }
        return true;
    }
}
