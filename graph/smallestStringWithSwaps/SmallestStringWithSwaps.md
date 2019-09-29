## 1202. Smallest String With Swaps

一开始没注意到，傻傻的用DFS找每种可能性...再判断 
后来发现其实本质上就是找联通分量...

那么就有两种办法：
1. union find

union find没压缩路径也会超时..

2. dfs
