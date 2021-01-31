/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}

// class Solution {
// public int removeDuplicates(int[] nums) {
// int i = 0;
// for (int n : nums) {
// if (i == 0 || n > nums[i - 1]) {
// nums[i] = n;
// i++;
// }
// }

// return i;
// }
// }

// @lc code=end
