## 599. Minimum Index Sum of Two Lists
两个字符串数组，找到相同的元素，并且各自的索引和最小。
把第一个数组放进哈希表，遍历第二个数组即可。
时间复杂度O(L1 + L2), 空间复杂度O(L1 * x), x是字符串平均长度
值得一提的是最后
```
return res.toArray(new String[0]);  // 1
return res.toArray(new String[]{}); // 2
```
1和2有很大的性能差距，1提交beat90多, 2只有70多。
评论区给了个链接说明：
https://shipilev.net/blog/2016/arrays-wisdom-ancients/
> Bottom line: toArray(new T[0]) seems faster, safer, and contractually cleaner, and therefore should be the default choice now.
