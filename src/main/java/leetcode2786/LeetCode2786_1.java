package leetcode2786;

public class LeetCode2786_1 {

    public long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = new long[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] & 1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int party = nums[i] & 1;
            long cur = Math.max(dp[party] + nums[i], dp[1 - party] + nums[i] - x);
            res = Math.max(res, cur);
            dp[party] = cur;
            // 官网答案针对dp[party]赋值采用了如下方式，但是只有在nums数组中是负数的情况下才可能需要考虑，这里不太需要考虑这件事
            // dp[party] = Math.max(cur, dp[party]);
        }
        return res;
    }

    public static void main(String[] args) {
        // [8,50,65,85,8,73,55,50,29,95,5,68,52,79]
        {
            LeetCode2786_1 leetCode2786 = new LeetCode2786_1();
            int[] nums = new int[]{2, 3, 6, 1, 9, 2};
            int x = 5;
            long l = leetCode2786.maxScore(nums, x);
            System.out.println(l);
        }
        System.out.println("======================");
        {
            LeetCode2786_1 leetCode2786 = new LeetCode2786_1();
            int[] nums = new int[]{2, 4, 6, 8};
            int x = 3;
            long l = leetCode2786.maxScore(nums, x);
            System.out.println(l);
        }
        System.out.println("======================");

        {
            LeetCode2786_1 leetCode2786 = new LeetCode2786_1();
            int[] nums = new int[]{38,92,23,30,25,96,6,71,78,77,33,23,71,48,87,77,53,28,6,20,90,83,42,21,64,95,84,29,22,21,33,36,53,51,85,25,80,56,71,69,5,21,4,84,28,16,65,7};
            int x = 52;
            long l = leetCode2786.maxScore(nums, x);
            System.out.println(l);
        }
        System.out.println("======================");
    }
}
