package leetcode503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈 + 循环数组 ： 思路很巧的一题
 */
public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
