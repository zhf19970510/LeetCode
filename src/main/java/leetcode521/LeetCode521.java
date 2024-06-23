package leetcode521;

public class LeetCode521 {

    public int findLUSLength(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen != bLen) {
            return Math.max(aLen, bLen);
        }
        if(!a.contains(b) || !b.contains(a)) {
            return aLen;
        }
        return -1;
    }

    public static void main(String[] args) {
        {
            LeetCode521 leetCode521 = new LeetCode521();
            System.out.println(leetCode521.findLUSLength("aaa", "bbb"));
        }

        {
            LeetCode521 leetCode521 = new LeetCode521();
            System.out.println(leetCode521.findLUSLength("aba", "cdc"));
        }

        {
            LeetCode521 leetCode521 = new LeetCode521();
            System.out.println(leetCode521.findLUSLength("aaa", "aaa"));
        }
    }
}
