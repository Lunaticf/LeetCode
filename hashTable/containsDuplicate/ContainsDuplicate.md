## 217. Contains Duplicate

一个数组 判断是否有重复的元素
1. 哈希表
2. 先排序再检查是否有重复
这题python可以一行解决~java8也可以啦
```
return len(nums) > len(set(nums))
```