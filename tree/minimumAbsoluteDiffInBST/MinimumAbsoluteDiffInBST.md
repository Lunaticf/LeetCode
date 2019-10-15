## 530. Minimum Absolute Difference in BST
主要就是利用BST的特性，中序遍历得到递增序列。

如果不是BST呢？

把所有值拿出来排序就行了

另外就是不用全局变量的写法该怎么写，只需要传递两个变量过去就行了，要用引用类型，可以int arr[2];