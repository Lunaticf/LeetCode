## 213. House Robber II

简单的House Robber的升级版
头尾也是连着的

最简单的想法就是，其实只需要判断第一家要不要偷
- 偷第一家 最后一家就不会偷res = F[..-1]
- 不偷第一家 res = F[1..]