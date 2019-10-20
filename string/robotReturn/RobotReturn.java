package leetCode.string.robotReturn;

public class RobotReturn {
    public boolean judgeCircle(String moves) {
        // 判断R是否等于L U等于D
        char[] ca = moves.toCharArray();
        int R = 0, L = 0, D = 0, U = 0;
        for (char c : ca) {
            if (c == 'R') {
                R++;
            } else if (c == 'L') {
                L++;
            } else if (c == 'U') {
                U++;
            } else if (c == 'D') {
                D++;
            }
        }

        return R == L && U == D;
    }
}
