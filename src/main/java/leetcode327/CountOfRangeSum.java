package leetcode327;

public class CountOfRangeSum {

    public static int countOfRangeSum1(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }


        return count(sum, 0, sum.length - 1, lower, upper);
    }

    // arr[L..R]已经不传进来了，只传进来sum（前缀和数组）
    // 在原始的arr[L...R]中，有多少个子数组在[lower, upper]上
    public static int count(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }

        // 范围上不只一个位置
        int mid = L + ((R - L) >> 1);

        int leftPart = count(sum, L, mid, lower, upper);

        int rightPart = count(sum, mid + 1, R, lower, upper);

        int merge = merge(sum, L, mid, R, lower, upper);

        return leftPart + rightPart + merge;
    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += Math.max(0, windowR - windowL);
        }

        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 5, 1};
        int lower = -2;
        int upper = 2;
        System.out.println(countOfRangeSum1(nums, -2, 2));
    }
}
