package leetcode522;

import java.util.Arrays;

public class LeetCode522 {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> {
            boolean flag = ((o2.length() - o1.length() >= 0) && (o2.compareTo(o1) >= 0));
            if (flag) {
                return 1;
            } else {
                return -1;
            }
        });
        int maxLen = -1;
        for (int i = 0; i < strs.length - 1; i++) {
            boolean b = strs[i].length() == strs[i + 1].length();
            if (!b) {
                return strs[i].length();
            }
            while (i < strs.length - 1) {
                if (strs[i].equals(strs[i + 1])) {
                    maxLen = -1;
                    i++;
                } else {
                    maxLen = Math.max(maxLen, strs[i].length());
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        {
            LeetCode522 leetCode522 = new LeetCode522();
            String[] strs = new String[] {"aba","cdc","eae"};
            System.out.println(leetCode522.findLUSlength(strs));
        }
        {
            LeetCode522 leetCode522 = new LeetCode522();
            String[] strs = new String[] {"aaa","aaa","aa"};
            System.out.println(leetCode522.findLUSlength(strs));
        }
    }
}
