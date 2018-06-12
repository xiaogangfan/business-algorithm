package amazon;

import entity.TreeNode;
// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.

//     10
//    /  \
//   5   15
//      /  \
//      6  20

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * BST树的属性就是中序遍历是有序的，即 left<=current<right
 * 可以使用递归对的方式来看
 * Created by anduo on 17-3-13.
 */
public class ValidateBinarySearchTree {

    // 中序遍历，下一个访问的节点值一定大于上一次最后访问的节点值
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 访问左子树
        if (!isValidBST(root.left)) return false;
        // 访问根节点
        if (pre != null && root.val <= pre.val) return false;
        pre = root;
        // 访问右子树
        if (!isValidBST(root.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        // [10,5,15,null,null,6,20]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean valid = new ValidateBinarySearchTree().isValidBST(new TreeNode(0));
        System.out.println(valid);
    }
}
