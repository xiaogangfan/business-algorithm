package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

// http://www.lintcode.com/problem/validate-binary-search-tree
// 验证二叉查找树

//给定一个二叉树，判断它是否是合法的二叉查找树(BST)
//一棵BST定义为：
//节点的左子树中的值要严格小于该节点的值。
//节点的右子树中的值要严格大于该节点的值。
//左右子树也必须是二叉查找树。
//一个节点的树也是二叉查找树。

import entity.TreeNode;

/**
 * Created by anduo on 17-3-14.
 */
public class Question08ValidateBinarySearchTree {

    private class ResultType {
        boolean valid;
        int maxVal, minVal;

        public ResultType(boolean valid, int maxVal, int minVal) {
            this.valid = valid;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }

    public ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        // 分割问题
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);

        // 如果左右都不是平衡二叉树，就返回
        if (!left.valid || !right.valid) {
            return new ResultType(false, 0, 0);
        }

        // 如果不满足 left.max<=current<right.min
        if ((root.left != null && root.val <= left.maxVal)
                || (root.right != null && root.val >= right.minVal)) {
            return new ResultType(false, 0, 0);
        }
        int max = Math.max(root.val, right.maxVal);
        int min = Math.min(root.val, left.minVal);
        return new ResultType(true, max, min);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root).valid;
    }


}
