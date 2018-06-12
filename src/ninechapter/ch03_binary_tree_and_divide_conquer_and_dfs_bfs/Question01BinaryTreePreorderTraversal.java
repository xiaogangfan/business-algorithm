package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

//    1
//     \
//      2
//     /
//    3
// result: 1->2->3

/**
 * http://www.lintcode.com/problem/binary-tree-preorder-traversal
 * 二叉树的前序遍历
 * Created by anduo on 17-3-13.
 */
public class Question01BinaryTreePreorderTraversal {
    // 非递归算法 Non-Recursion (Recommend)
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }

    // version2 递归解法
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    /***************************************************************/
    // version3 : divide & conquer
    // 分治法
    // Merge Sort:局部有序，然后整体有序
    // Quick Sort:整体有序，然后局部有序
    // Most of the Binary Tree Problem！
    public ArrayList<Integer> preorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversal3(root.left);
        ArrayList<Integer> right = preorderTraversal3(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;


    }

}
