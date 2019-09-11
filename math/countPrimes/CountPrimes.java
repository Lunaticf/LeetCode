package leetCode.math.countPrimes;

/**
 * @Author Lunaticf
 * @Date 2019/9/11
 */
public class CountPrimes {
    public int countPrimes(int n) {
        // 默认全是false 都是素数
        boolean[] isPrimes = new boolean[n];

        // 可以优化 比sqrt(n)大的素数乘以1...sqrt(n)之间的倍数一定已经被筛过了
        // for (int i = 2; i < n; i++) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!isPrimes[i]) {
                for (int j = 2; j * i < n; j++) {
                    // 置为非素数
                    isPrimes[j * i] = true;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrimes[i]) {
                res++;
            }
        }
        return res;
    }

}
