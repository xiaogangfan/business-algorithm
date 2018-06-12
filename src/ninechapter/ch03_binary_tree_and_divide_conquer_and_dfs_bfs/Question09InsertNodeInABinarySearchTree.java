package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;
//在二叉查找树中插入节点
//http://www.lintcode.com/zh-cn/problem/insert-node-in-a-binary-search-tree/
//给定一棵二叉查找树和一个新的树节点，将节点插入到树中。你需要保证该树仍然是一棵二叉查找树。
//           2             2
//          / \           / \
//         1   4   -->   1   4
//            /             / \
//           3             3   6

import entity.TreeNode;

/**
 * Created by anduo on 17-3-14.
 */
public class Question09InsertNodeInABinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
