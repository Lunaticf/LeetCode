## 110. Balanced Binary Tree

check一棵树是否是平衡的

显然是递归的一道题，判断一颗树是平衡的同时要判断左右子树是否是平衡的 并且左右子树高度不能相差1

伪代码
```
也就是isBalancedTree(root.left) && isBalancedTree(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1
```

但是这样直接去写复杂度是O(NlogN)的 原因是我们每次递归的时候需要重复计算高度，其实已经计算过了。

所以可以在求高度的时候同时判断是否平衡 复杂度优化到O(N)