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
        return 0;
    }

    public static int rangeBitwiseAnd3(int m, int n) {
        if(m == 0){
            return 0;
        }
        int temp = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            temp <<= 1;
        }
        return m * temp;

    }


    // 低位会很混乱，所以只看高位情况
    public static int rangeBitwiseAnd4(int m,int n){
        if(m == 0){
            return 0;
        }
        int temp = 1;
        while (m!=n){
            m >>= 1;
            n >>= 1;
            temp <<= 1;
        }
        return m*temp;
    }

    public static void main(String[] args) {
        // int a = rangeBitwiseAnd3(13,18);
        int a = rangeBitwiseAnd4(13,18);
        System.out.println(a);
    }



}
