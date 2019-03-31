package LeetCode.array.plusOne;

public class PlusOne {

    private static void printDigits(int[] digits) {
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4};
        int[] digits1 = {1, 2, 3, 9};
        int [] digits2 = {9, 9, 9, 9};
        PlusOne p = new PlusOne();
        printDigits(p.plusOne(digits));
        printDigits(p.plusOne(digits1));
        printDigits(p.plusOne(digits2));
    }

    public int[] plusOne(int[] digits) {
         int len = digits.length;

         for (int i = len - 1; i >= 0; i--) {
             if (digits[i] + 1 <= 9) {
                 digits[i] += 1;
                 return digits;
             }
             digits[i] = 0;
         }

         digits = new int[len + 1];
         digits[0] = 1;
         return digits;
    }
}
