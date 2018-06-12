package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

// http://www.lintcode.com/problem/lowest-common-ancestor/
// 最近公共祖先
// 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。最近公共祖先是两个节点的公共的祖先节点且具有最大深度。

//          4
//         / \
//        3   7
//           / \
//          5   6

//  LCA(3, 5) = 4
//  LCA(5, 6) = 7
//  LCA(6, 7) = 7

/**
 * Created by anduo on 17-3-14.
 */
public class Question05LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {// LCA(4,7)
            return root;
        }

        // Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);// 左子树的公共父节点
        TreeNode right = lowestCommonAncestor(root.right, A, B);// 右子树的公共父节点

        // Conquer
        if (left != null && right != null) {
            // 如果左右都不是null的，就返回他们的父节点，也就是当前的root节点
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}
