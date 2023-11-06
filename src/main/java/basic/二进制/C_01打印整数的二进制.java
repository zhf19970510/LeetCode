package basic.二进制;

public class C_01打印整数的二进制 {

    public static void main(String[] args) {
        int num = 4;
        print(num);
        System.out.println();
        // 整数最小数的相反数

        int a = Integer.MIN_VALUE;
        int b = ~a;
        int c = ~a + 1;
        int d = -a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
    }

    /**
     * 打印整数的32进制数据
     *
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
}
