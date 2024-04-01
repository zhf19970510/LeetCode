package NC;

/**
 * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
 * 2.假设 nums[-1]=nums[n]=-00
 * 3.对于所有有效的i都有 nums[] != nums[i + 1]
 * 4.你可以使用O(logN)的时间复杂度实现此问题吗?
 */
public class BM19 {

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int findPeakElement (int[] nums) {
            // write code here
            if(nums.length == 1) {
                return 0;
            }
            if(nums.length == 2) {
                return nums[0] < nums[1] ? 1 : 0;
            }
            if(nums[0] > nums[1]) {
                return 0;
            }
            if(nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
            int left = 1;
            int right = nums.length - 2;
            while(left <= right) {
                int mid = ((right - left) >> 1) + left;
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                if(nums[mid] < nums[mid - 1]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }
}
