//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 877 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 前序遍历：根，左子树，右子树
    // 中序遍历：左子树，根，右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 维护一个中序遍历中每个节点位置的哈希表，以便查找位置
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, preorder.length, inorder, 0, inorder.length, inMap);
    }

    private TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // Teminator
        if (preStart == preEnd) return null;

        // Processing
        // 前序遍历的第一个节点就是当前的节点。查找这个节点在中序遍历的位置，再分左右子树递归。
        TreeNode newRoot = new TreeNode(preorder[preStart]);
        int inRootIndex = inMap.get(preorder[preStart]);
        int leftCount = inRootIndex - inStart; // 左子树长度，对于前序遍历和中序遍历是一样的

        // Drill down
        newRoot.left = buildSubTree(preorder, preStart + 1, preStart + leftCount + 1, inorder, inStart, inRootIndex, inMap);
        newRoot.right = buildSubTree(preorder, preStart + leftCount + 1, preEnd, inorder, inRootIndex + 1, inEnd, inMap);

        // Return
        return newRoot;
    }
}
/*
class Solution {
    // 前序遍历：根，左子树，右子树
    // 中序遍历：左子树，根，右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // Teminator
        if (preStart == preEnd) return null;

        // Processing
        TreeNode newRoot = new TreeNode(preorder[preStart]);
        int inRootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inRootIndex = i;
                break;
            }
        }
        int leftCount = inRootIndex - inStart; // 左子树长度，对于前序遍历和中序遍历是一样的

        // Drill down
        newRoot.left = buildSubTree(preorder, preStart + 1, preStart + leftCount + 1, inorder, inStart, inRootIndex);
        newRoot.right = buildSubTree(preorder, preStart + leftCount + 1, preEnd, inorder, inRootIndex + 1, inEnd);

        // Return
        return newRoot;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
