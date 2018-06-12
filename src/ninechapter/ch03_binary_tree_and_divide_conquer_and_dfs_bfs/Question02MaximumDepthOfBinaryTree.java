package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

//二叉树的最大深度
//   1
//  / \
// 2   3
//    / \
//   4   5

/**
 * http://www.lintcode.com/problem/maximum-depth-of-binary-tree
 * <p>
 * Created by anduo on 17-3-13.
 */
public class Question02MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 分治法
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
