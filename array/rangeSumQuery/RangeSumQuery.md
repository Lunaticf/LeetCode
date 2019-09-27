##303. Range Sum Query - Immutable
1. brute force
2. 预先计算所有的组合 cache起来 用数组会内存超过限制 因为O(N^2) 用Map的话会少一点
3. 最佳做法 记录每个0-j的和 计算i-j时用0-j - 0-i