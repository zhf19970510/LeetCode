package NC;

/**
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标(下标从0开始)，否则返回-1
 * 数据范围:0 < len(nums)< 2x 10^5，数组中任意值满足 |val| < 10^9
 * 进阶:时间复杂度 O(log n)，空间复杂度 O(1)
 */
public class BM17 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search (int[] nums, int target) {
            // write code here
            if(nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while(left <= right) {
                int mid = ((right - left) >> 1) + left;
                if(nums[mid] == target) {
                    return mid;
                }else if(nums[mid] < target) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
