## 190. Reverse Bits
Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.

In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.

Java需要注意的点

1. 逆转字符串再用Integer.parseInt去做是不行的，因为parseInt只能处理31位的数，而传过去的字符串多了一位其实。
可以用parseUnsignedInt或Long.parse

2. 位操作 正解