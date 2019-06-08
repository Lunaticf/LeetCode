package LeetCode.hashTable.fourSum2;


import java.util.HashMap;


public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int p = 0; p < D.length; p++) {
                        if (A[i] + B[j] + C[k] + D[p] == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }


    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                hashMap.put(a + b, hashMap.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                res += hashMap.getOrDefault(-(c + d), 0);
            }
        }

        return res;
    }
}
