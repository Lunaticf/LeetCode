## 198. House Robber
简单的一维动态规划

dp方程也比较好想
F[i] = Math.max(F[i - 1], F[i - 2] + nums[i]);

分为不偷上一家和偷了上一家