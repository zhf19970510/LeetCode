package Leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || n <= 3) {
            return new ArrayList<>(0);
        }

        Arrays.sort(nums);

        int[] target2Arr = new int[n];
        for (int i = 0; i < n; i++) {
            target2Arr[i] = target - nums[i];
        }

        List<List<Integer>> resList = new ArrayList<>();
        int firstNum;
        int pivot;
        int left;
        int right;
        for (int i = 0; i < n; i++) {
            firstNum = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            pivot = i + 1;
            while (pivot < n - 2) {
                left = pivot + 1;
                right = n - 1;
                while (left < right) {
                    long tmp = nums[pivot] + nums[left];
                    if (tmp > 0 && nums[right] > 0) {
                        int remained = (int) (Integer.MAX_VALUE - tmp);
                        if (nums[right] > remained) {
                            int right0 = right - 1;
                            while (left < right0 && nums[right0] == nums[right]) {
                                right0 -= 1;
                            }
                            right = right0;
                            continue;
                        }
                    }
                    if (tmp < 0 && nums[right] < 0) {
                        int remained = (int) (Integer.MIN_VALUE - tmp);
                        if (nums[right] < remained) {
                            int left0 = left + 1;
                            while (left0 < right && nums[left0] == nums[left]) {
                                left0 += 1;
                            }
                            left = left0;
                            continue;
                        }
                    }
                    tmp += nums[right];
                    if (tmp == target2Arr[i]) {
                        List<Integer> targetInnerList = Arrays.asList(firstNum, nums[pivot], nums[left], nums[right]);
                        resList.add(targetInnerList);
                        int right0 = right - 1;
                        while (left < right0 && nums[right0] == nums[right]) {
                            right0 -= 1;
                        }
                        right = right0;
                    } else if (tmp < target2Arr[i]) {
                        int left0 = left + 1;
                        while (left0 < right && nums[left0] == nums[left]) {
                            left0 += 1;
                        }
                        left = left0;
                    } else {
                        int right0 = right - 1;
                        while (left < right0 && nums[right0] == nums[right]) {
                            right0 -= 1;
                        }
                        right = right0;
                    }
                }
                int pivot0 = pivot + 1;
                while (pivot0 < n - 2 && nums[pivot0] == nums[pivot]) {
                    pivot0 += 1;
                }
                pivot = pivot0;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 0, -1, 0, -2, 2};
            int target = 0;
            Leetcode18 leetcode18 = new Leetcode18();
            List<List<Integer>> lists = leetcode18.fourSum(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
            System.out.println("==========================");
        }
        {
            int[] nums = new int[]{2, 2, 2, 2, 2, 2};
            int target = 8;
            Leetcode18 leetcode18 = new Leetcode18();
            List<List<Integer>> lists = leetcode18.fourSum(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
            System.out.println("==========================");
        }

        {
            int[] nums = new int[]{-2, -2, -2, 2, 2, 2};
            int target = 0;
            Leetcode18 leetcode18 = new Leetcode18();
            List<List<Integer>> lists = leetcode18.fourSum(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
            System.out.println("==========================");
        }

        {
            int[] nums = new int[]{-2, -2, -2, 2, 2, 2};
            int target = 0;
            Leetcode18 leetcode18 = new Leetcode18();
            List<List<Integer>> lists = leetcode18.fourSum(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
            System.out.println("==========================");
        }

        {
            int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
            int target = -294967296;
            Leetcode18 leetcode18 = new Leetcode18();
            List<List<Integer>> lists = leetcode18.fourSum(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
            System.out.println("==========================");
        }


        {
            System.out.println((long) (1000000000 + 1000000000 + 1000000000 + 1000000000));
            System.out.println("==========================");
            System.out.println(1000000000);
        }
        System.out.println("***********");
        {
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);
        }

        {
            long a1 = 2147483648L;
            long a2 = -2147483649l;
            System.out.println(a1 + a2 == -1);
            System.out.println(a1 + a2);
        }
    }
}
