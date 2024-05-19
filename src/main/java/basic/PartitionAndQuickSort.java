package basic;

public class PartitionAndQuickSort {

    public static void splitNum(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int mostR = arr.length - 1;
        while (index < arr.length) {
            if(arr[index] <= arr[mostR]) {
                swap(arr, lessEqualR + 1, index);
                lessEqualR++;
                index++;
            }else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
