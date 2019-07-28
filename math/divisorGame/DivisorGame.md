## 1025. Divisor Game
Easy题
一个数字N 每个人找一个0-N能被N整除的数，然后减掉它，找不到就输了。

每个人是按optimal的做法

- 2 alice取1，bob lose
- 3 alice取1 bob取1 alice必然lose 这里可以看到3的时候先手必输
- 4 因为3的时候先手必输 所以alice取1 bob必输
- 5 alice只能取1 然后4的情况下先手必赢 所以alice输

可以看到规律偶数的情况下先手必赢

所以直接一行代码N%2==0判断奇数偶数即可

或者动态规划 本质一样 复杂度高

