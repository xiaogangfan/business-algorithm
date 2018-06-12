package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

import java.util.ArrayList;

/**
 * Created by anduo on 17-3-14.
 */
public class Question10SearchRangeInBinarySearchTree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // divide
        ArrayList<Integer> left = searchRange(root.left, k1, k2);
        ArrayList<Integer> right = searchRange(root.right, k1, k2);

        // conquer
        result.addAll(left);
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        result.addAll(right);

        return result;
    }
}
