## 235. Lowest Common Ancestor of a Binary Search Tree
一开始没注意是bst 没有利用bst的特性写了一个通用的 也过了

bst的话就很简单了 

如果p和q都比当前node值大 就去右边子树 反之亦然 

如果p和q在两边 必然就是lowest comman ancestor! 迭代写就行了 

三行的写法很优雅
