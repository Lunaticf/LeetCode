## 205. Isomorphic Strings
判断两个字符串是不是同构的
"eggg" => "addk"
Java map.put 如果Key之前不存在 返回值是null 如果key存在，返回之前的value
可以用两个哈希表，
将e与a首先都映射到1
然后g与d都映射到2
再判断g与k时, 第一个哈希表返回3，第二个返回Null, 不是同构的。
时间复杂度O(N) 空间复杂度O(N)

