package leetCode.hashTable.longestWordInDict;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestWordInDict {
    public String longestWord(String[] words) {
        // 初看题意有点难以理解..
        // 其实就是一个word必须每个从0开始的子串都存在才符合条件
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        String res = "";
        for (String word : words) {
            if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                boolean valid = true;
                for (int i = 1; i < word.length(); i++) {
                    if (!wordSet.contains(word.substring(0, i))) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    res = word;
                }
            }
        }
        return res;

    }

    /**
     * Trie node
     */
    class Node {
        char c;
        List<Node> childs;
        boolean isWord;
    }

    /**
     * 初始化Trie tree
     * @param word
     * @return
     */
    public Node initTree(String word) {
        Node root = new Node();
        root.isWord = true;
        root.childs = new ArrayList<>();

        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            Node node = new Node();
            node.c = word.charAt(i);
            node.childs = new ArrayList<>();

            p.childs.add(node);
            p = node;
        }
        p.isWord = true;
        return root;
    }

    public void insertTree(String word, Node root) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 遍历树
            boolean find = false;
            for (Node node : root.childs) {
                // 如果能找到匹配的
                if (node.c == c) {
                    root = node;
                    find = true;
                    break;
                }
            }

            // 如果没有匹配的
            if (!find) {
                Node node = new Node();
                node.c = c;
                node.childs = new ArrayList<>();
                root.childs.add(node);
                root = node;
            }
        }
        root.isWord = true;
    }

    private String res = "";
    public String longestWord1(String[] words) {
        Node root = initTree(words[0]);
        for (int i = 1; i < words.length; i++) {
            insertTree(words[i], root);
        }

        dfs(root, "");
        return res;
    }

    private void dfs(Node root, String s) {

        if (root.isWord) {
            if (s.length() > res.length() || ((s.length() == res.length()) && (s.compareTo(res) < 0))) {
                res = s;
            }
        } else {
            return;
        }

        for (Node node : root.childs) {
            dfs(node, s + node.c);
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"w","wo","wor","worl", "world"};
        System.out.println(new LongestWordInDict().longestWord1(words));
    }


}
