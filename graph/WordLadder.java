package leetCode.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        new WordLadder().ladderLength("hit", "cog", Arrays.asList(
                "hot","dot","dog","lot","log","cog"));
    }

    /**
     * bfs  还可以双向优化
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // bfs
        // 少不了队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // 方便查找符合的字符串
        Set<String> set = new HashSet<>(wordList);
        int level = 1;


        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] ca = s.toCharArray();
                // 对字符串每一位进行26个字母的替换
                for (int j = 0; j < s.length(); j++) {
                    char raw = ca[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ca[j] = c;
                        String tempStr = new String(ca);
                        if (!tempStr.equals(s) && set.contains(tempStr)) {
                            if (tempStr.equals(endWord)) {
                                return level + 1;
                            } else {
                                queue.offer(tempStr);
                                set.remove(tempStr);
                            }
                        }
                    }
                    // 还原
                    ca[j] = raw;
                }
            }
            level++;
        }
        return 0;
    }
}
