## 160. Intersection of Two Linked Lists
1. brute force
2. 先算出两个的长度 把较长的先往前移offset个位置 再遍历
缺点是先要计算两个链表的长度
但是时间复杂度也是O(N)的了
3. 不用先计算出长度 比较巧妙
当任意一个pointer遍历到末尾时就放到另一个链表的开头
https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!