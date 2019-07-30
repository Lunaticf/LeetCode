package LeetCode.array.gasStation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        for (int i = 0; i < N; i++) {
            // 从每个站开始测试
            int curStation = i;
            int curGas = gas[i];
            while (curGas >= cost[curStation]) {
                // 可以去下一站
                int nextStation = (curStation+ 1) % N;
                curGas = curGas - cost[curStation] + gas[nextStation];
                curStation = nextStation;
                if (curStation == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int nowGas = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            nowGas += gas[i] - cost[i];
            if (nowGas < 0) {
                res = i + 1;
                nowGas = 0;
            }
        }

        return totalGas - totalCost >= 0 ? res : - 1;
    }
}
