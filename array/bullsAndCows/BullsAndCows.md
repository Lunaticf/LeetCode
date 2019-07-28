## 299. Bulls and Cows
公牛和母牛？题目好长

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

看例子，大意就是给一个数字，然后猜这个数字。每一位如果完全匹配，是一个bull。
如果位置错误，是一个cow。

自己一开始用哈希表写的比较繁琐...后来看了评论区用两个数组完美解决。

both-bull的思想。