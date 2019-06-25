## 779. K-th Symbol in Grammar
Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
每次把0换成01，把1换成10
可以看成一棵树，
如果K是偶数，就是右孩子节点，其父节点就是K/2
K是奇数，父节点为（K+1）/ 2
