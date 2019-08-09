## 7. Reverse Integer
虽然是Easy
可是有两个点：

为了处理溢出：
1. 每一次更新res的时候判断是否溢出
2. 使用Long类型，判断将其转换为Int后是否与Long还相等 抖了个机灵