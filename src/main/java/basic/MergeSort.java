package basic;

public class MergeSort {
    public static void mergeSort1(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + (R - L) >> 1;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if(arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
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
    }

    public static void mergeSort2(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {
            int L = 0;
            while (L < N) {
                int M = 0;
                if(N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }

                if(M == N - 1) {
                    break;
                }

                int R1 = M + 1;

                int R = 0;
                if(N - 1 - M >= step) {
                    R = M + step;
                }else {
                    R = N - 1;
                }
                merge(arr, L, M, R);

                if(R == N - 1) {
                    break;
                }else {
                    L = R + 1;
                }
            }

            if(step > (N / 2)) {
                break;
            }else {
                step *= 2;
            }
        }
    }

}
