package myStudy;

/**
 * 获取任意整数的二进制位数字
 */
public class getBitAnyNumber {
    public static void main(String[] args) {
        getBitAnyNumber1(Integer.MIN_VALUE >>> 31);
        getBitAnyNumber1(1 << 30);
        getBitAnyNumber1(~(1 << (31 - 30)));
        getBitAnyNumber1(-2147483648 >>> 30);
        getBitAnyNumber1(2147483647);
    }

    public static void getBitAnyNumber(int N){
        for(int i = 31; i >=0; i--){
            System.out.print(N >> i & 1);
        }
        System.out.println();
    }

    public static void getBitAnyNumber1(int N){
        for(int i = 31; i >= 0; i--){
            System.out.print( (N & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
