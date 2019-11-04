package leetCode.greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        // 这题还挺好玩的
        // 需要注意一点
        // 20找15的时候我们尽可能的先给10块 贪心
        // 因为如果现在有5 5 5 10 来了20 给了 5 5 5 再来10 失败
        // 本质是因为 5 5 就相当于10 这也是为什么商贩喜欢零钱呀
        // 这里code不是很clean doesn't matter
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
                continue;
            }
            if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                    continue;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
