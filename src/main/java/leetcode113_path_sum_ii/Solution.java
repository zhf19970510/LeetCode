package leetcode113_path_sum_ii;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList();
        if(root == null){
            return ret;
        }
        List<Integer> curList = new ArrayList();
        process(root, 0, targetSum, curList, ret);
        return ret;
    }

    public void process(TreeNode x, int preSum, int targetSum, List<Integer> curList, List<List<Integer>> ret){
        if(x.left == null && x.right == null){
            int curSum = preSum + x.val;
            if(curSum == targetSum){
                List<Integer> tmpList = copyList(curList);
                tmpList.add(x.val);
                ret.add(tmpList);
            }
            return;
        }

        curList.add(x.val);
        preSum += x.val;
        if(x.left != null){
            process(x.left, preSum, targetSum, curList, ret);
        }
        if(x.right != null){
            process(x.right, preSum, targetSum, curList, ret);
        }

        curList.remove(curList.size() - 1);
    }

    public List<Integer> copyList(List<Integer> source){
        List<Integer> ret = new ArrayList();
        for(Integer i : source){
            ret.add(i);
        }
        return ret;
    }

}
