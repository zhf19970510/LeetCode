package leetcode107_binary_tree_level_order_transval;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null){
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            ret.add(0, curAns);
        }
        return ret;
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