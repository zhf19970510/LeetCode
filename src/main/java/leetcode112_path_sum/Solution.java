package leetcode112_path_sum;


import tree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        process(root, 0, targetSum);
        return isPathSum;
    }

    boolean isPathSum = false;

    public void process(TreeNode x, int preSum, int targetSum){
        if(x.left == null && x.right == null){
            int curSum = preSum + x.val;
            if(curSum == targetSum){
                isPathSum = true;
            }
            return;
        }

        preSum += x.val;
        if(x.left != null){
            process(x.left, preSum, targetSum);
        }
        if(x.right != null){
            process(x.right, preSum, targetSum);
        }
    }
}
