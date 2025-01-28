package basic.小和问题;

/**
 * 每个数的左边有m个数比当前数小，将所有这m个数累加起来，数组遍历累加起来即为最终结果
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid)
                +
                process(arr, mid + 1, r)
                + merge(arr, l, mid, r);

    }

    public static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }


}
