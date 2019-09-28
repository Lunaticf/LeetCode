package leetCode.graph.smallestStringWithSwaps;

import java.util.*;

public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));

        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps(s, pairs));
    }

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // dfs的时候判断是不是已经加入到某分量
    private Set<Integer> visited = new HashSet<>();

    // 记录分量
    private List<List<Integer>> unions = new ArrayList<>();

    // union find版记录分量
    private HashMap<Integer, List<Integer>> unions1 = new HashMap<>();

    private int[] unionArr;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        char[] res = s.toCharArray();

        // 先要用pairs建图 邻接链表 注意是无向图 加两遍
        // dfs
//        for (List<Integer> pair : pairs) {
//            graph.computeIfAbsent(pair.get(0), k -> new ArrayList<>());
//            graph.get(pair.get(0)).add(pair.get(1));
//
//            graph.computeIfAbsent(pair.get(1), k -> new ArrayList<>());
//            graph.get(pair.get(1)).add(pair.get(0));
//        }

        // union find 建union
        unionArr =  new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            unionArr[i] = i;
        }
        for (List<Integer> pair : pairs) {
            unionArr[find(pair.get(0))] = unionArr[find(pair.get(1))];
        }


        // 找联通分量 dfs/union find皆可 遍历graph的key来找
        // dfs
//        for (Integer key : graph.keySet()) {
//            if (!visited.contains(key)) {
//                List<Integer> union = new ArrayList<>();
//                union.add(key);
//
//
//                dfs(key, union);
//
//                unions.add(union);
//            }
//        }

        // union find
        for (int i = 0; i < unionArr.length; i++) {
            int parent = find(i);
            unions1.computeIfAbsent(parent, k -> new ArrayList<>());
            unions1.get(parent).add(i);
        }

        // 为了复用下面的代码 直接转成List了..省事一点
        for (Integer key : unions1.keySet()) {
            unions.add(unions1.get(key));
        }

        // 根据connected component构建dest string
        for (List<Integer> union : unions) {
            Collections.sort(union);

            char[] temp = new char[union.size()];
            for (int i = 0; i < union.size(); i++) {
                temp[i] = s.charAt(union.get(i));
            }
            // sort
            Arrays.sort(temp);
            // refill
            for (int i = 0; i < temp.length; i++) {
                res[union.get(i)] = temp[i];
            }
        }

        return new String(res);

    }

    private void dfs(Integer node, List<Integer> union) {
        visited.add(node);
        if (graph.get(node) == null) {
            return;
        }
        for (Integer dest : graph.get(node)) {
            if (!visited.contains(dest)) {
                union.add(dest);
                dfs(dest, union);
            }
        }
    }

    // 最美的union find
    private int find(int n) {
        return n == unionArr[n] ? n : (unionArr[n] = find(unionArr[n]));
    }



}
