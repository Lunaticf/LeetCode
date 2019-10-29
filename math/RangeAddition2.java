package leetCode.math;

/**
 * @Author Lunaticf
 * @Date 2019/10/29
 */
public class RangeAddition2 {
    /**
     * 有一个矩阵 初始化为0 并且有很多更新操作
     * 每次加会把该坐标到左上角的所有区域都加1
     * 最后求最大的元素的个数
     * 等价于求多个长方形的交集的大小 想了一下，不停的min就行了
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int i = m;
        int j = n;
        for (int p = 0; p < ops.length; p++) {

                i = Math.min(i, ops[p][0]);
                j = Math.min(j, ops[p][1]);

        }
        return i * j;
    }
}
