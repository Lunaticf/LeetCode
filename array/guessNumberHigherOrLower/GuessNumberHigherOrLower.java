package leetCode.array.guessNumberHigherOrLower;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == -1) {
                high = mid - 1;
            } else if (res == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    // cheat the compiler
    private int guess(int n) {
        return 1;
    }
}
