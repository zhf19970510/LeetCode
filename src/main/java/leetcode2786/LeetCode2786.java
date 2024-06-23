package leetcode2786;

public class LeetCode2786 {

    public long maxScore(int[] nums, int x) {
        result = 0L;
        long preSum = nums[0];
        int preNum = nums[0];
        int curIndex = 1;
        dfs(nums, x, curIndex, preSum, preNum);
        return result;
    }

    public long result = 0L;

    public void dfs(int[] nums, int x, int curIndex, long preSum, int preNum) {
        if (curIndex == nums.length - 1) {
            int curValue = nums[nums.length - 1];
            int a = (int) ((curValue & 1) ^ (preNum & 1));
            if (a == 0) {
                result = Math.max(result, curValue + preSum);
            } else {
                result = Math.max(result, Math.max(preSum, curValue + preSum - x));
            }
        } else {
            int curValue = nums[curIndex];
            dfs(nums, x, curIndex + 1, preSum, preNum);
            int a = (int) ((curValue & 1) ^ (preNum & 1));
            if (a == 0) {
                dfs(nums, x, curIndex + 1, preSum + curValue, curValue);
            } else {
                dfs(nums, x, curIndex + 1, preSum - x + curValue, curValue);
            }
        }
    }

    public static void main(String[] args) {
//        {
//            LeetCode2786 leetCode2786 = new LeetCode2786();
//            int[] nums = new int[]{2, 3, 6, 1, 9, 2};
//            int x = 5;
//            long l = leetCode2786.maxScore(nums, x);
//            System.out.println(l);
//        }
//        System.out.println("======================");
//        {
//            LeetCode2786 leetCode2786 = new LeetCode2786();
//            int[] nums = new int[]{2, 4, 6, 8};
//            int x = 3;
//            long l = leetCode2786.maxScore(nums, x);
//            System.out.println(l);
//        }
        System.out.println("======================");

        {
            LeetCode2786 leetCode2786 = new LeetCode2786();
            int[] nums = new int[]{38,92,23,30,25,96,6,71,78,77,33,23,71,48,87,77,53,28,6,20,90,83,42,21,64,95,84,29,22,21,33,36,53,51,85,25,80,56,71,69,5,21,4,84,28,16,65,7};
            int x = 52;
            long l = leetCode2786.maxScore(nums, x);
            System.out.println(l);
        }
        System.out.println("======================");
    }
}
