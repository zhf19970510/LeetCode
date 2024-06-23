package leetcode419;

public class LeetCode419 {

    public int countBattleships(char[][] board) {
        int res = 0;
        if (board[0][0] == 'X') {
            res++;
        }
        for (int i = 1; i < board[0].length; i++) {
            if (board[0][i] == 'X' && board[0][i - 1] == '.') {
                res++;
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    if (board[i - 1][j] == '.' && board[i][j] == 'X') {
                        res++;
                    }
                } else {
                    if (board[i - 1][j] == '.' && board[i][j - 1] == '.' && board[i][j] == 'X') {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        {
            LeetCode419 leetCode419 = new LeetCode419();
            char[][] board = new char[][] {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
            System.out.println(leetCode419.countBattleships(board));
        }
        {
            LeetCode419 leetCode419 = new LeetCode419();
            char[][] board = new char[][] {{'.'}};
            System.out.println(leetCode419.countBattleships(board));
        }
    }
}
