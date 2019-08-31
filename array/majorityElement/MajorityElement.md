## 169. Majority Element
有很多种解法
https://leetcode.com/articles/majority-element/

1. brute force
2. hashMap
以上没什么好说的
3. sort 有点意思 因为必然存在这个数 所以直接数组的中间必然是这个数
4. 随机
也很有意思，每次随机选一个数看看是不是，不是就再选。

Boyer-Moore Voting Algorithm是最好的
就是碰到新的元素重新投票这样
