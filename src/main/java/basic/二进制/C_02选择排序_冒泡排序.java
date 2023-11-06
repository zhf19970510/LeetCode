package basic.二进制;

public class C_02选择排序_冒泡排序 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 数字数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("*****选择排序******");
        int[] arr = new int[]{3, 9, 8, 7, 5, 6, 10, 5, 7, 1, 2};
        printArray(arr);
        selectSort(arr);
        printArray(arr);

        System.out.println("*****冒泡排序******");
        arr = new int[]{3, 9, 8, 7, 5, 6, 10, 5, 7, 1, 2};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}
