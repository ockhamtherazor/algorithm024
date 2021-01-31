/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;

        int rem = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rem - 1);
        reverse(nums, rem, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end
