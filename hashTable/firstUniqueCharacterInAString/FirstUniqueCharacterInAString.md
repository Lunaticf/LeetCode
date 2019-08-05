## 387. First Unique Character in a String
在一个字符串中，找到第一个未重复的字符的索引
首先想到用一个哈希表，存储每个字符出现的次数，再遍历，次数为1的返回。
时间复杂度O(N), 空间复杂度O(N)
因为全是小写字母，开一个26长度的数组就可以。

最优的是可以indexof(c) == lastIndexof(c) 这样效率很高

