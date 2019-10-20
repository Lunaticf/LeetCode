## 653. Two Sum IV - Input is a BST
常规做法 先构造有序数组 O(N)

或者用哈希表 就不限于BST了 任何树都可以 O(N)

或者对于每一个节点，在BST中查找是否有k-val 复杂度O(NLogN)