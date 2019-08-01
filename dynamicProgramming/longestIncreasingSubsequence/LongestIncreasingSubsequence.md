## 300. Longest Increasing Subsequence
这题很经典，但是三种解法全部理解不容易。

- 暴力递归记忆化
- 动态规划
    动态规划可能是最好写的。
    
    F[i]代表以i结尾的最长序列的长度
    
    那么我们需要遍历i以前所有元素，看i插在他们的后面是否能更长
    
    F[i] = Math.max(F[0]...F[i-1] if num[i] > num[0..i-1])
- 所谓耐心排序
    

一篇讲的还不错的博客
https://segmentfault.com/a/1190000003819886