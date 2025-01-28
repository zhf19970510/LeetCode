package basic.快速排序;

/**
 * <pre>
 * 快速排序核心：
 * 将数据划分为三个区域，< = >
 *
 * 遍历数组：取出一个目标的数：target
 * 当前数（目前吧遍历到的数）< target,将当前数和<区域的下一个数做交换，<向右扩，当前数跳下一个。
 * 当前数 == target，将当前数直接跳到下一个
 * 当前数 > target，将当前数和>区域的前一个数做交换，>向左扩，当前数停在原地。
 *
 * </pre>
 */
public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }



}
