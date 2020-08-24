public class LeetCode201 {
    public static int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int temp = 1;
            for (int j = m; j <= n; j++){
                temp = (j >> i) & 1;
                if(0 == temp || j == Integer.MAX_VALUE){
                    temp = 0;
                    break;
                }
            }
            result += temp << i;
        }
        return result;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        int result = m;
        for (int i = m;i<=n;i++){
            result &= i;
        }
        return result;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        for(int i = m; i <= n; i++){

        }
    }


    public static void main(String[] args) {
        int a = rangeBitwiseAnd(5,7);
        System.out.println(a);
    }



}
