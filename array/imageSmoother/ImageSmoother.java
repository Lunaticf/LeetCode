package leetCode.array.imageSmoother;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];

        // 要注意要复制一个数组...不然遍历的过程中会用到已经改变的值啊
        int[] stepX = new int[]{0, 0, 0, 1, 1, 1, -1, -1, -1};
        int[] stepY = new int[]{0, 1, -1, 0, 1, -1, 0, 1, -1};

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int count = 0;
                for (int k = 0; k < stepX.length; k++) {
                    int x = i + stepX[k];
                    int y = j + stepY[k];
                    if (x >= 0 && x < M.length && y >= 0 && y < M[0].length) {
                        sum += M[x][y];
                        count++;
                    }
                }

                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
