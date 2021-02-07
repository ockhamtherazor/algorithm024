import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0)
            return new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            if (freqMap.containsKey(n))
                freqMap.put(n, freqMap.get(n) + 1);
            else
                freqMap.put(n, 1);
        }

        // User priority queue to create a heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for (int key : freqMap.keySet()) {
            heap.add(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
// @lc code=end
