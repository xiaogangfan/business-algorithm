package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;


// http://www.lintcode.com/zh-cn/problem/binary-tree-level-order-traversal
// 二叉树的层次遍历
// 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
//
//           3
//          / \
//          9  20
//            /  \
//           15   7
//

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anduo on 17-3-14.
 */
public class Question06BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> levels = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                levels.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(levels);
        }
        return result;
    }
}
