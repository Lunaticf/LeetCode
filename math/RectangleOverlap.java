package leetCode.math;

/**
 * @Author Lunaticf
 * @Date 2019/11/2
 */
public class RectangleOverlap {
    /**
     * 转换为1维的线段比较的问题
     * 首先思考如何判断一维的两个线段是否相交
     *                  x3         x4
     *                |--------------|
     *      |--------------|
     *      x1              x2
     *
     * x1 < x4 && x3 < x2
     *
     * 转换到2d就是在x和y维度上都要相交
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
