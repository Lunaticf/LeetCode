package leetCode.tree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // 有多少种不同的BST能表示1-n
        // 挺喜欢这题的
        // 首先1-n,我们可以定义1...n分别作为root 这样肯定是不一样的
        // F(n) = G(1) + ... + G(n) F表示numTrees G表示以n为root有多少种
        // 而G(i) = F(i - 1) * F(n - i);
        // F(n) = F(0) * F(n - 1) + F(1) * F(n - 2) + ... + F(n - 1) * F(0);

        // 1...n
        int[] F = new int[n + 1];
        // 注意0也算1种
        F[0] = 1;
        F[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                F[i] += F[j - 1] * F[i - j];
            }
        }

        return F[n];

    }
}
