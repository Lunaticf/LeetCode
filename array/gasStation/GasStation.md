## 134. Gas Station
Input: 

gas  = [1,2,3,4,5]

cost = [3,4,5,1,2]

Output: 3

计算从哪个站出发可以绕一周

1. 直接模拟就可以过 但是效率很低 是O(N^2)

正解，两条rule:
If car starts at A and can not reach B. Any station between A and B
can not reach B.(B is the first station that A can not reach.)

If the total number of gas is bigger than the total number of cost. There must be a solution.
(Should I prove them?)

走完整个环的前提是gas的总量要大于cost的总量，这样才会有起点的存在。
如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
https://leetcode.com/problems/gas-station/discuss/42578/Easy-and-simple-proof-with-Python-solution.