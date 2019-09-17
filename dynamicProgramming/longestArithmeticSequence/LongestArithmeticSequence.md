## 1027. Longest Arithmetic Sequence
DP题

还是有点难度的

因为diff是未知的 所以我们需要用HashMap

dp[i]表示以i结尾的 -> (diff, value) 状态
```
diff =  dp[i] - dp[0..i-1] 
if dp[0..i-1] 存在有diff的链条
dp[i][diff]就可以加1
```