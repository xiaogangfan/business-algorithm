package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

// 二叉树中的最大路径和
// 给出一棵二叉树，寻找一条路径使其路径和最大，
// 路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
//      1
//     / \
//    2   3
// 返回 6

import entity.TreeNode;

import static java.lang.Math.max;

/**
 * http://www.lintcode.com/zh-cn/problem/binary-tree-maximum-path-sum/
 * Created by anduo on 17-3-13.
 */
// TODO(分治法的最高境界)
public class Question04BinaryTreeMaximumPathSum {

    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath;

        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType help(TreeNode root) {
        if (root == null) {// 极端情况
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = help(root.left);
        ResultType right = help(root.right);

        // Conquer
        // 合并从root开始往下走的路径和
        int singlePath = max(left.singlePath, right.singlePath) + root.val;
        singlePath = max(singlePath, 0);

        // 当前节点到左右子树的最大路径
        int maxPath = max(left.maxPath, right.maxPath);
        // 当前节点跨根节点的最大路径
        maxPath = max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        // 分治法
        // 三种情况：
        // 1、左子树
        // 2、右子树
        // 3、跨根节点

        ResultType result = help(root);
        return result.maxPath;
    }
}
