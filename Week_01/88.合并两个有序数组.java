/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, i = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[i--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }

        // If there are still elements in nums2
        while (tail2 >= 0) {
            nums1[i--] = nums2[tail2--];
        }
    }
}
// @lc code=end
