package leetCode.hashTable.topKFrequentElements;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 预先分配nums.length长度的空间
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 得到每个数字的频率
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 再放到list里面去
        for (int num : hashMap.keySet()) {
            int freq = hashMap.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        // 倒着遍历
        for (int i = bucket.length - 1; i >= 0 & res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }

    // priorityQueue
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (
            b.getValue() - a.getValue()
        ));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }
}
