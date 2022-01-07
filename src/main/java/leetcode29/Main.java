package leetcode29;

public class Main {

    public static int generateNum(){
        double random = Math.random();
        int flag = 1;
        if(random < 0.5){
            flag = ~flag +1;
        }
        return (int) (flag * Integer.MAX_VALUE * Math.random());
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

        System.out.println(negNum(-1));

        System.out.println("========= 单独针对下面的情况进行边界测试 ============");
        System.out.println(div(Integer.MIN_VALUE, 1) == Integer.MIN_VALUE / 1);
        System.out.println(div(Integer.MIN_VALUE, -1) == Integer.MIN_VALUE / -1);
        System.out.println(div(Integer.MIN_VALUE, -1));
        System.out.println(Integer.MIN_VALUE / -1);
        System.out.println(div(Integer.MAX_VALUE, 1) == Integer.MAX_VALUE / 1);
        System.out.println(div(Integer.MAX_VALUE, -1) == Integer.MAX_VALUE / -1);
        System.out.println(div(Integer.MAX_VALUE, Integer.MIN_VALUE) == Integer.MAX_VALUE / Integer.MIN_VALUE);
        System.out.println(div(Integer.MIN_VALUE, Integer.MAX_VALUE) == Integer.MIN_VALUE / Integer.MAX_VALUE);
        System.out.println(div(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE / Integer.MAX_VALUE);
        System.out.println(0 / 2 == div(0 , 2));

        System.out.println("实例............");

        System.out.println(div(Integer.MIN_VALUE, 1 << 30));
        System.out.println(Integer.MIN_VALUE / (1 << 30));
        System.out.println(div(Integer.MIN_VALUE, (1 << 29)));
        System.out.println(Integer.MIN_VALUE / (1 << 29));

        System.out.println(Integer.MIN_VALUE / Integer.MIN_VALUE);

        System.out.println(-2147483648 / -1);
    }

    public static int add(int a, int b){
        int sum = 0;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    public static int negNum(int a){
        return add(~a, 1);
    }

    public static boolean isNeg(int a){
        return a < 0;
    }

    public static int div(int a, int b){

        if(b == 1){
            return a;
        }

//        if(b == -1){
//            return negNum(a);
//        }

        if(0 == a){
            return 0;
        }

        if(b == Integer.MIN_VALUE){
            if(a == Integer.MIN_VALUE){
                return 1;
            }
            return 0;
        }

        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;

        if(x == Integer.MIN_VALUE && y > (1 << 30)){
            return isNeg(a) ^ isNeg(b) ? negNum(1) : 1;
        }

        int res = 0;
        for(int i = 30; i >= 0; i = minus(i, 1)){
            if((x >>> i) >= y){
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }

        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public int divide(int dividend, int divisor) {
        return div(dividend, dividend);
    }

}
