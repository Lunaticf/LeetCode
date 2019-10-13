package leetCode.math.constructTheRectangle;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        // 1. 就是分解成两个因子
        // 2. 但是L>=W 必须 也就是必须前面大于等于后面
        // 3. L和W的差值应该尽可能小
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
