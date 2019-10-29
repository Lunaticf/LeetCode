package leetCode.bit.primeNumberOfSetBitsInBinaryRepresentaion;

/**
 * @Author Lunaticf
 * @Date 2019/10/28
 */
public class PrimeNumberOfSetBitsInBinaryRepresentaion {
    public int countPrimeSetBits(int L, int R) {
        boolean[] primes = new boolean[33];

        primes[2] = true;
        primes[3] = true;
        primes[5] = true;
        primes[7] = true;
        primes[11] = true;
        primes[13] = true;
        primes[17] = true;
        primes[19] = true;
        primes[23] = true;
        primes[29] = true;
        primes[31] = true;

        int count = 0;
        for (int i = L; i <= R; i++) {
            if (primes[Integer.bitCount(i)]) {
                count++;
            }
        }
        return count;
    }


}
