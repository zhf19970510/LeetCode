package basic.二分法;

public class BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L...R
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] == num) {
                return true;
            } else if(sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static int nearestLeftIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;     // 记录最左的下标
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int nearestRightIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;     // 记录最左的下标
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }


}
