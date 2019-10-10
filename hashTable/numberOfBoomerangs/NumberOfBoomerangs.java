package leetCode.hashTable.numberOfBoomerangs;

import java.util.HashMap;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        // brute force
        int M = points.length;  // M个点
        int res = 0;
        HashMap<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < M; i++) {
            // 对于每个点 check 其他所有点

            for (int j = 0; j < M; j++) {
                int temp = distance(points[j][0] - points[i][0],points[j][1] - points[i][1]);
                distances.put(temp, distances.getOrDefault(temp, 0) + 1);
            }

            for (Integer x : distances.keySet()) {
                int value = distances.get(x);
                res += value * (value - 1);
            }
            distances.clear();
        }
        return res;

    }

    private int distance(int x, int y) {
        return x * x + y * y;
    }


}
