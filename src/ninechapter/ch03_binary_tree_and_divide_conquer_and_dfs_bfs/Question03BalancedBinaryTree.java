package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

// <h1>平衡二叉树</h1>
// 给定一个二叉树,确定它是高度平衡的。
// 对于这个问题,一棵高度平衡的二叉树的定义是：
// 一棵二叉树中每个节点的两个子树的深度相差不会超过1。
//     A)  3             B)   3
//        / \                  \
//       9  20                 20
//         /  \                / \
//        15   7              15  7
// 二叉树A是高度平衡的二叉树，但是B不是

import entity.TreeNode;

/**
 * http://www.lintcode.com/zh-cn/problem/balanced-binary-tree/
 * Created by anduo on 17-3-13.
 */
public class Question03BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
