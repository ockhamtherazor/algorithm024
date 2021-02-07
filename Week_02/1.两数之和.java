import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i], b = target - a;
            if (map.containsKey(b))
                return new int[] { map.get(b), i };
            map.put(a, i);
        }
        return new int[] {};
    }
}
// @lc code=end
