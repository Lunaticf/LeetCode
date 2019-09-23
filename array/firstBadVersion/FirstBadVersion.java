package leetCode.array.firstBadVersion;

/**
 * @Author Lunaticf
 * @Date 2019/9/23
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        /* The isBadVersion API is defined in the parent class VersionControl.
              boolean isBadVersion(int version); */
        int low = 1;
        int high = n;
        int mid;
        while (low < high) {
            mid = low + (high - low)/2;
            // 如果是坏的版本 往前找
            if (isBadVersion(mid)) {
                // 注意不能是-1 因为这个mid有可能就是开始坏的版本
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // cheat the compiler
    private boolean isBadVersion(int version) {
        return true;
    }
}
