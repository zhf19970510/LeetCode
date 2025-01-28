package basic.bigger_than_right_twice;

/**
 * 针对数组中每一个数num，右侧有多少个数*2 < num，这样的数有多少个？
 */
public class BiggerThanRightTwice {

    public static int biggerThanRightTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid)
                +
                process(arr, mid + 1, r)
                + merge(arr, l, mid, r);

    }

    public static int merge(int[] arr, int L, int mid, int R) {
        // [L....M]     [M+1....R]
        int ans = 0;
        int windowR = mid + 1;
        for (int i = L; i <= mid; i++) {
            // 这里利用了归并排序已经排好序的特征，不用从头开始累计
            while (windowR <= R && arr[i] > (arr[windowR] << 1)) {
                windowR++;
            }
            ans += windowR - mid - 1;
        }

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return 0;
    }
}
