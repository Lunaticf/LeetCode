package leetCode.array.bitCharacter;

public class BitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 1;
            }
        }
        return false;
    }
}
