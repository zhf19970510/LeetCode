package leetcode105_construct_binary_tree_from_preorder_and_inorder_traversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果in[L2...R2]
    // 请建出整棵树返回头结点
    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }

        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return new TreeNode(pre[L1]);
        }

        int find = L2;
        while (in[find] != pre[L1]) {
            find++;
        }

        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}