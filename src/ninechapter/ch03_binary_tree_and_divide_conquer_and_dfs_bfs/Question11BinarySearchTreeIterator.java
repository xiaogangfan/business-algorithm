package ninechapter.ch03_binary_tree_and_divide_conquer_and_dfs_bfs;

import entity.TreeNode;

import java.util.Stack;

// 二叉查找树迭代器
// 设计实现一个带有下列属性的二叉查找树的迭代器：
// 元素按照递增的顺序被访问（比如中序遍历）
// next()和hasNext()的询问操作要求均摊时间复杂度是O(1)

//              10
//            /    \
//           1      11
//            \       \
//             6       12
// [1, 6, 10, 11, 12]

/**
 * Created by anduo on 17-3-14.
 */
public class Question11BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;

    //@param root: The root of binary tree.
    public Question11BinarySearchTreeIterator(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }

    //@return: return next node
    public TreeNode next() {
        // 中序遍历，非递归写法，就中间就要用栈
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;
        return node;
    }
}
