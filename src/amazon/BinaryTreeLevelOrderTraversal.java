package amazon;
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 102 https://leetcode.com/problems/binary-tree-level-order-traversal
 * 二叉树的层次遍历，其实也就是图的宽度优先遍历，记住使用数据结构Queue
 * 两层循环：
 * 外层：while 队列不为空
 * 内层：while 队列元素大小的所有元素全部出队，打印该层元素；把下层元素入队
 *
 * 扩展练习:https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * Created by anduo on 17-3-13.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // bfs 算法
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node;
        while (!queue.isEmpty()) {
            List<Integer> levels = new ArrayList<>();
            int nums = queue.size();
            while (nums-- > 0) {
                // 把该层的所有节点放到levels中，并且把这层的下级节点依次放入队列中
                node = queue.poll();
                levels.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 把该层节点的list加到result中
            result.add(levels);
        }
        return result;
    }
}
