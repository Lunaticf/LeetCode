## 290. Word Pattern

abba -> "cat dog dog cat"

看是不是一样的模式，

可以用两个Map或者一个map一个set

或者只用一个map稍微trick一点，
比如上面的例子：
a, cat->0
b, dog->1
利用map.put的返回值

但是要注意细节，Integer超出等于128的时候就不相等了地址，不能用==，要用Objects.equals