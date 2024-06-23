package basic.二进制;

public class C_05_一个数组中有一个数出现了K次_其他数都出现了M次_M_big_1_K_M_找出出现了K次的数 {

    /**
     * 一个数组中有一个数出现了K次，其他数都出现了M次，M>1_K < M，找出出现了K次的数
     * 要求额外空间复杂度O(1),时间复杂度O(n)
     * @param nums nums数组
     * @param K k次
     * @param M m次
     */
    public int printKTimesNum(int[] nums, int K, int M) {
        int[] arr = new int[32];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= 31; j++) {
                if(((nums[i] >> j) & 1) == 1) {
                    arr[j] += 1;
                }
            }
        }

        int result = 0;
        int start = 1;
        for(int j = 0; j < arr.length; j++) {
            start = start * 2;
            if(arr[j] % M != 0) {
                result += start / 2;
            }
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] % M == 0) {
                continue;
            }
            if((arr[j] % M) == K) {
                result |= (1 << j);
            } else {
                return -1;
            }
        }
        if(result == 0) {
            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) {
                    count++;
                }
            }
            if(count != K) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        C_05_一个数组中有一个数出现了K次_其他数都出现了M次_M_big_1_K_M_找出出现了K次的数 t1 = new C_05_一个数组中有一个数出现了K次_其他数都出现了M次_M_big_1_K_M_找出出现了K次的数();
        int[] nums = new int[] {2, 3, 5, 7, 8, 12, 15, 2, 3, 5, 7, 8, 15, 12, 2, 3, 5, 7, 8, 15};
        System.out.println(t1.printKTimesNum(nums, 2, 3));
    }
}
