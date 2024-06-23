package basic.二进制;

public class C_04一个数组中有两种数出现了奇数次_其他数都出现了偶数次_怎么找到并打印这两种数 {


    /**
     * 一个数组中有两种数出现了奇数次_其他数都出现了偶数次_怎么找到并打印这两种数
     */
    public void printTwoNumbers(int[] nums) {
        int eor = 0;
        for(int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        int lastOne = getLastOneNumber(eor);
        int eor1 = 0;
        for(int i = 0; i < nums.length; i++) {
            if((lastOne & nums[i]) != 0) {
                eor1 ^= nums[i];
            }
        }
        System.out.println(eor1);
        System.out.println(eor ^ eor1);
    }

    public int getLastOneNumber(int num) {
        return num & (-num);
    }
}
