//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    // 遍历，递归向下，返回时将之前一层加入的数删除
    // 满足条件则加入结果集并返回
    // 剪枝条件是，如果剩余的数不足以达到k，就无需再继续了
    private void combine(List<Integer> comb, int n, int k, int cur) {
        // Terminator
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        // Processing

        // Drill down
        for (int i = cur; i <= n - k + 1; i++) {
            comb.add(i);
            combine(comb, n, k - 1, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
