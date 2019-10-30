package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/10/30
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
