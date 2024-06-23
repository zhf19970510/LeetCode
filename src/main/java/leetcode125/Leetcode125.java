package leetcode125;

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0, j = chs.length - 1; i < chs.length && j >= 0 && i <= j;) {
            while (i < chs.length && !isLetterAndNumber(chs[i])) {
                i++;
            }

            while (j >= 0 && !isLetterAndNumber(chs[j])) {
                j--;
            }

            if((i >= chs.length && j >= 0) || (j < 0 && i < chs.length)) {
                return false;
            }
            if(i >= chs.length && j < 0) {
                return true;
            }

            if(i == j) {
                return true;
            }

            if(chs[i] >= 65 && chs[i] <= 90) {
                chs[i] += 32;
            }

            if(chs[j] >= 65 && chs[j] <= 90) {
                chs[j] += 32;
            }

            if(chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isLetterAndNumber(char ch) {
        return (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90);
    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        System.out.println(leetcode125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
