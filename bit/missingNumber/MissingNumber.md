## 268. Missing Number

应该有很多方法

1. 可以用本来的和减去现在的和 gauss
复杂度O(N), 空间也是O(1)

2. sort O(nlogn)

3. hashset 先全部放进去 然后看哪个数是没有的 两遍 O(N)

4. bit 两个相同的数异或会得到0 所以我们把正确的所有数和数组所有数异或 最后会得到miss number


这题综上所述 gauss和bit是最佳选择