package myStudy;

/**
 * 使用位运算实现加减乘除
 */
public class BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;            // 无进位相加信息-> sum
            b = (a & b) << 1;       // 进位信息
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i , 1)){
            if((x >>> i) >= y){
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int generateNum(){
        double random = Math.random();
        int flag = 1;
        if(random < 0.5){
            flag = ~flag +1;
        }
        return (int) (flag * Integer.MAX_VALUE * random);
    }

    public static void main(String[] args) {
        int testNum = 1000000;
        System.out.println("开始测试....");
        for(int i = 0; i < testNum; i++){
            int a = generateNum();
            int b = generateNum();
            if(div(a, b) != a / b){
                System.out.println("Oop");
                System.out.println("异常数据： " + a + "," + b);
                break;
            }
        }
        System.out.println("结束测试！");
    }

}
