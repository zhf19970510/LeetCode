package leetcode2779;

import java.util.Arrays;

public class LeetCode2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int[] preRangeRight = new int[nums.length];
        preRangeRight[0] = nums[0] + k;
        int j = 0;
        int curRight = preRangeRight[j];
        int currentCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int k0 = nums[i] - k;
            int k1 = nums[i] + k;
            preRangeRight[i] = k1;
            if (k0 <= curRight) {
                currentCount++;
                result = Math.max(result, currentCount);
            } else {
                do {
                    curRight = preRangeRight[++j];
                } while (j <= i && k0 > curRight);
                currentCount = i - j + 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{4, 6, 1, 2};
            System.out.println(leetCode2779.maximumBeauty(nums, 2));
        }

        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println(leetCode2779.maximumBeauty(nums, 4));
        }

        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{52, 34};
            System.out.println(leetCode2779.maximumBeauty(nums, 21));
        }

        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{49, 26};
            System.out.println(leetCode2779.maximumBeauty(nums, 12));
        }

        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{5, 57, 46};
            System.out.println(leetCode2779.maximumBeauty(nums, 15));
        }
        {
            LeetCode2779 leetCode2779 = new LeetCode2779();
            int[] nums = new int[]{51, 91, 92, 16, 65};
            System.out.println(leetCode2779.maximumBeauty(nums, 27));
        }
    }
}
