package leetcode2965;

public class Leetcode2965 {


    // 官方解法，新开辟一个数组存值
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int[] res = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                res[0] = i;
            }
            if (count[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

    // 个人想到的方法
    public int[] findMissingAndRepeatedValues2(int[][] grid) {
        int len = grid.length;
        int target;
        int same = 0;
        int miss = 0;
        boolean flag = false;
        lb1:
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                target = i * len + j + 1;
                while (grid[i][j] != target) {
                    int cur = grid[i][j];
                    int targetI = (cur - 1) / grid.length;
                    int targetJ = cur - targetI * grid.length - 1;
                    int tmp = grid[targetI][targetJ];
                    if (tmp != cur) {
                        grid[targetI][targetJ] = cur;
                        grid[i][j] = tmp;
                    } else {
                        if (!flag) {
                            same = tmp;
                            flag = true;
                        }
                        miss = target;
                        grid[i][j] = target;
                    }
                }
            }
        }
        return new int[]{same, miss};
    }
}
