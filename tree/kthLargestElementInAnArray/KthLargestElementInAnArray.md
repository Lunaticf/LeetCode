## 215. Kth Largest Element in an Array

1. 堆 (可以自己实现或者用PriorityQueue)
2. 快排 这里是O(N)
The partition part of quick sort is O(n), that's the part that we're using in the algorithm. The log(n) part comes from looking at both sides of the pivot point, but in this case we're altering the algorithm to only look at one side.
3. 最简单 sort O(nlogn)