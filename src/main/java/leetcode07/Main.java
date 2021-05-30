package leetcode07;

/**
 *
 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

 假设环境不允许存储 64 位整数（有符号或无符号）。


 示例 1：

 输入：x = 123
 输出：321
 示例 2：

 输入：x = -123
 输出：-321
 示例 3：

 输入：x = 120
 输出：21
 示例 4：

 输入：x = 0
 输出：0


 提示：

 -231 <= x <= 231 - 1
 */


/**
 * 解题思路：
 *  对数字部分取反，然后对数字的长度和数字与整数最大值进行比较，看看超出范围没有，如果超出范围，那么返回0，如果没有超出 那么与开始的正负号比较，得出结果 与符号位拼接即为结果
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(Integer.MIN_VALUE);
        System.out.println(result);
    }
}

class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean isPositiveNum = x > 0;
        String s1 = "" + Math.abs(x);
        char[] chs = s1.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chs.length; i++){
            sb.append(chs[chs.length - i - 1]);
        }
        String result = sb.toString();
        if(isPositiveNum && (result.length() >= 10 && result.compareTo("2147483647") > 0)){
            return 0;
        }
        else if(!isPositiveNum && (result.length() >= 10 && result.compareTo("2147483648") > 0)){
            return 0;
        }
        return isPositiveNum ? Integer.parseInt(result) : (-1) * Integer.parseInt(result);
    }

    /**
     * 给出官网解决方案，很牛逼，如果不记得翻看LeetCode官网，数学法
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}