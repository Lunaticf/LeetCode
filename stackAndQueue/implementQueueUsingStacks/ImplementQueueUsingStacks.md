## 232. Implement Queue using Stacks
两个栈 每次要pop的时候：
1. 如果第二个栈为空 把第一个栈元素倒入第二个栈
2. 不为空 直接pop

由于dump的操作非常少 可以近似认为均摊复杂度是O(1)的