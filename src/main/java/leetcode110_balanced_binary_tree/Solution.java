package leetcode110_balanced_binary_tree;

/**
 * Definition for a binary tree node.
 * public class tree.TreeNode {
 *     int val;
 *     tree.TreeNode left;
 *     tree.TreeNode right;
 *     tree.TreeNode() {}
 *     tree.TreeNode(int val) { this.val = val; }
 *     tree.TreeNode(int val, tree.TreeNode left, tree.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * 如果一棵树中序遍历的结果严格递增，则这棵树一定是搜索二叉树。
 *
 */
public class Solution {

    // 以某个节点为头结点的时候，1) 整颗树是否平 2)整棵树的高度是多少
    class NodeInfo{
        boolean isBalanced;
        int height;

        public NodeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public NodeInfo getNodeInfo(TreeNode root){
        if(root == null){
            return new NodeInfo(0, true);
        }
        NodeInfo leftNodeInfo = getNodeInfo(root.left);
        NodeInfo rightNodeInfo = getNodeInfo(root.right);
        int height = Math.max(leftNodeInfo.height, rightNodeInfo.height) + 1;
        boolean isBalanced = leftNodeInfo.isBalanced && rightNodeInfo.isBalanced && Math.abs(leftNodeInfo.height - rightNodeInfo.height) < 2;
        return new NodeInfo(height, isBalanced);
    }

    public boolean isBalanced(TreeNode root) {
        return getNodeInfo(root).isBalanced;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}