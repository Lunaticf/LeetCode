package LeetCode.array.canPlaceFlowers;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1, 0,0 };
        new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int left = (i == 0?0:flowerbed[i-1]);
                int right = (i == flowerbed.length - 1?0:flowerbed[i+1]);
                if (left == 0 && right == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
            if (count >= n) return true;
        }
        return false;
    }
}
