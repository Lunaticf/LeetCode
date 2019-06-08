## 454. 4Sum II
Given four lists A, B, C, D of integer values, 
compute how many tuples (i, j, k, l) 
there are such that A[i] + B[j] + C[k] + D[l] is zero.
1. brute force 超时 O(N^4)
2. 可以先把A和B的数组两重循环得到相加的结果存到hashMap中,
再对C和D做两重循环，跟twoSum一样去check hashMap。
O(N^2) 空间复杂度O(N^2) 可以看到是trade off