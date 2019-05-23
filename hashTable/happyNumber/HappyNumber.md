## 202. Happy Number
一个数，每位数的平方相加，不停迭代，最后得到1就是happy number。
否则的话，陷入循环
如何判断已经进入循环就可以了，用hashSet
更优的解法是用Floyd cycle detection
跟检测链表是否有环一样，快慢指针