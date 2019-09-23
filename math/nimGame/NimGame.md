## 292. Nim Game
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. 
You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game. 
Write a function to determine whether you can win the game given the number of stones in the heap.

有一堆石头，你和对手take turns去拿，每人可以拿1-3个石头，每人都采取最优的策略，你先手，谁赢。
- 1个石头，必赢
- 2个石头，拿2个，必赢
- 3个石头，拿3个，必赢
- 4个石头，拿1，到f(3)，对手必赢，拿2，到f(2)，对手必胜
可以动态规划，f[n] = f[n-1] || f[n-2] || f[n-3]

TLE了...打印出来看发现可以整除4的必胜！也很好理解