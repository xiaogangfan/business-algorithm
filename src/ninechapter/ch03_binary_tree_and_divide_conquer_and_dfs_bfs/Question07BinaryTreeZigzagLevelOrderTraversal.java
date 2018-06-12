package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

//http://www.lintcode.com/zh-cn/problem/binary-tree-zigzag-level-order-traversal/
// 二叉树的锯齿形层次遍历
// 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）

//            3
//           / \
//          9  20
//            /  \
//           15   7

// output
//[
// [3]
// [20,9]
// [15,7]
//]

/**
 * Created by anduo on 17-3-14.
 */
public class Question07BinaryTreeZigzagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // 整体也是宽度优先遍历
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 定义两个栈，分别存储当前层的节点和下层节点
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> tmp;
        currLevel.push(root);

        boolean normalOrder = true;
        while (!currLevel.isEmpty()) {
            ArrayList<Integer> levels = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                levels.add(node.val);
                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            result.add(levels);

            // 交换两个stack
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;
    }
}
