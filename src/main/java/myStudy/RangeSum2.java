package myStudy;

/**
 * 获取数组总从第i位到第j位的累加和，使用前缀和的方法
 */
public class RangeSum2 {

    private int[] preSum;

    public RangeSum2(int [] array){
        int N = array.length;
        preSum = new int[N];
        for(int i = 1; i < N; i++){
            preSum[i] = preSum[i - 1] + array[i];
        }
    }

    public int rangeSum(int L, int R){
        return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
    }
}
