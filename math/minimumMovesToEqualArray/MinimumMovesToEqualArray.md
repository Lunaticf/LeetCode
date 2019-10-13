## 453. Minimum Moves to Equal Array Elements

纯math....

显然我们每次都需要让除了最大值以外的元素加1

假设move m次 最后元素都是x
sum + m * (n - 1) = x * n

实际上x = minNum + m 
因为最小数每次移动都必须参与

=> m = sum - minNum * n

或者反向思考 每次等于将一个数-1