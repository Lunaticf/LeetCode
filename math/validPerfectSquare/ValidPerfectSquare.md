## 367. Valid Perfect Square

这题挺好的，有很多种方法，
判断一个数是不是平方数

1. brute force
2. binary serach
3. 牛顿迭代法

4. trick 比较好的做法
```
4 = 1 + 3
9 = 1 + 3 + 5
16 = 1 + 3 + 5 + 7
发现规律了没~
```

值得注意的是我们需要用long来避免mid*mid的溢出
