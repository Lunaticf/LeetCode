package LeetCode.array.bullsAndCows;

public class BullsAndCows {
    public static void main(String[] args) {
        new BullsAndCows().getHint("1123", "0111");
    }

    public String getHint(String secret, String guess) {
        int countA = 0;

        int[] secretArr = new int[10];
        int[] guessArr = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) countA++;
            secretArr[secret.charAt(i) - '0']+=1;
            guessArr[guess.charAt(i) - '0']+=1;
        }

        int both = 0;
        // 因为数组小 遍历即可 还不用对secret做set处理
        for (int i = 0; i < 10; i++) {
            both += Math.min(secretArr[i], guessArr[i]);
        }

        return countA + "A" + (both-countA) + "B";

    }
}
