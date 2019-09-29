## 389. Find the Difference
两个字符串 后一个多一个字符
找到那个字符

很简单 可以所有字符异或！举一反三~

或者用hashtable check~

虽然这题比较简单 但是很多种优化方法挺有意思的


那个男人又来了！one line!
```java
public char findTheDifference(String s, String t) {
    return (char) (s + t).chars().reduce(0, (c, d) -> c ^ d);
}
```