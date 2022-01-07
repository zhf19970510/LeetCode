package leetcode1744;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        int[] candiesCount = new int[] {7,4,5,3,8};
//        int[][] queries = new int[][]{{0,2,2},{4,2,4},{2,13,1000000000}};
        int[] candiesCount = new int[] {5,2,6,4,1};
        int[][] queries = new int[][]{{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}};

        boolean[] result1 = solution.canEat(candiesCount, queries);
        for (boolean b : result1) {
            System.out.print(b + " ");
        }
    }
}

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int[] candiesCountAcc = new int[candiesCount.length];
        int tmpResult = 0;
        for(int i = 0; i < candiesCount.length; i++){
            tmpResult += candiesCount[i];
            candiesCountAcc[i] = tmpResult;
        }
        int length = queries.length;
        boolean[] result = new boolean[length];
        int[] queriesTmp;
        for(int i = 0; i < queries.length; i++){
            queriesTmp = queries[i];
            if(queriesTmp[0] == 0){
                if(queriesTmp[1] >= 0 && queriesTmp[1] <= (candiesCountAcc[queriesTmp[0]] - 1)){
                    result[i] = true;
                }
                else{
                    result[i] = false;
                }
            }
            else{
                if(queriesTmp[1] >= (candiesCountAcc[queriesTmp[0]-1] / queriesTmp[2]) && queriesTmp[1] <= (candiesCountAcc[queriesTmp[0]] - 1)){
                    result[i] = true;
                }
                else{
                    result[i] = false;
                }
            }
        }
        return result;
    }
}