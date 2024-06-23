package basic.二进制;

public class C_03把一个int类型的数提取出最右侧的1来 {

    public static int getLastOneNumber(int a) {
        return a & (-a);
    }

    public static void main(String[] args) {
        // a 的 相反数 = ~ + 1
        int a = (int) (Math.random() * 1000);
        System.out.println(a);
        System.out.println(getLastOneNumber(a));
    }
}
