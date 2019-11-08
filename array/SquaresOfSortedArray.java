package leetCode.array;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        // 数组A是增序的
        // 返回他们的平方，同样全部排序
        // 负数的平方 -7 < -5 但是会顺序错乱 -7和5同理
        // 单纯排序的话是O(NlogN)
        // 一定有一个O(N)的方法
        // 夹逼？
        int[] res = new int[A.length];
        int pos = res.length - 1;

        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            if (Math.abs(A[i]) < Math.abs(A[j])) {
                res[pos--] = A[j] * A[j];
                j--;
            } else {
                res[pos--] = A[i] * A[i];
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new SquaresOfSortedArray().sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
