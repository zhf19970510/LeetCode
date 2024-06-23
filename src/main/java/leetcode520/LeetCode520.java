package leetcode520;

public class LeetCode520 {

    public boolean detectCapitalUse(String word) {
        boolean flag = true;
        int firstLetterRange = isBigOrLessLetter(word.charAt(0));
        int lastLetterRange = word.length() >= 2 ? isBigOrLessLetter(word.charAt(1)) : 2;
        if(word.length() >= 2 && firstLetterRange == 1 && lastLetterRange == 0) {
            return false;
        }
        for(int i = 2; i < word.length(); i++) {
            int curLetterRange = isBigOrLessLetter(word.charAt(i));
            if(curLetterRange != lastLetterRange) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public int isBigOrLessLetter(char ch) {
        if(ch >= 65 && ch <= 90) {
            return 0;
        }
        if(ch >= 97 && ch <= 122) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        {
            LeetCode520 leetCode520 = new LeetCode520();
            System.out.println(leetCode520.detectCapitalUse("USA"));
        }
        System.out.println("=========================");
        {
            LeetCode520 leetCode520 = new LeetCode520();
            System.out.println(leetCode520.detectCapitalUse("FlaG"));
        }
        System.out.println("=========================");
    }
}
