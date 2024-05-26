package basic;

import java.util.Stack;

public class PartitionAndQuickSort {

    public static void splitNum(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int mostR = arr.length - 1;
        while (index < arr.length) {
            if(arr[index] <= arr[mostR]) {
//                swap(arr, lessEqualR + 1, index);
//                lessEqualR++;
//                index++;
                swap(arr, ++lessEqualR, index++);
            }else {
                index++;
            }
        }
    }

    public static void splitNum2(int[] arr) {
        int N = arr.length;
        int lessR = -1;
        int moreL = N - 1;
        int index = 0;
        while (index < moreL) {
            if(arr[index] < arr[N - 1]) {
                swap(arr, ++lessR, index++);
            }else if(arr[index] > arr[N - 1]){
                swap(arr, --moreL, index);
            }else {
                index++;
            }
        }
        swap(arr, N - 1, moreL);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // arr[L...R]范围上，拿arr[R]作划分值
    // L...R < = >
    public static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index < moreL) {
            if(arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            }else if(arr[index] > arr[R]){
                swap(arr, --moreL, index);
            }else {
                index++;
            }
        }
        swap(arr, R, moreL);

        return new int[] {lessR + 1, moreL};
    }

    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if(L >= R) {
            return;
        }
        int[] equalE = partition(arr, L, R);
        process(arr, L, equalE[0]);
        process(arr, equalE[1] + 1, R);
    }

    public static class Job {
        public int L;
        public int R;
        public Job(int left, int right){
            this.L = left;
            this.R = right;
        }
    }

    /**
     * 非递归快排
     */
    public static void quickSort2(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int L = cur.L;
            int R = cur.R;
            int[] equals = partition(arr, L, R);
            if(equals[0] > L) {     // 有 < 区域
                stack.push(new Job(L, equals[0] - 1));
            }
            if(equals[1] < R) {
                stack.push(new Job(equals[1] + 1, R));
            }
        }
    }

}
