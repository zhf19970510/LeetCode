package leetcode342;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 */


/**
 * 首先可以判断n为2次幂的数据，然后再对该数据开根号，将开根号后的数据 相乘，如果等于n，那么证明这个数据就是 4次幂的数据
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.isPowerOfFour(Integer.MAX_VALUE - 3);
        System.out.println(b);
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        boolean flag = n > 0 && (n & (n - 1)) == 0;
        if(!flag) return false;
        int a = (int) Math.sqrt(n);
        return a*a == n;
    }

    /**
     * 前言
     * 如果 nn 是 44 的幂，那么 nn 一定也是 22 的幂。因此我们可以首先判断 nn 是否是 22 的幂，在此基础上再判断 nn 是否是 44 的幂。
     *
     * 判断 nn 是否是 22 的幂可以参考「231. 2的幂的官方题解」。由于这一步的方法有很多种，在下面的题解中，我们使用
     *
     * \texttt{n \& (n - 1)}
     * n & (n - 1)
     *
     * 这一方法进行判断。
     *
     * 方法一：二进制表示中 11 的位置
     * 思路与算法
     *
     * 如果 nn 是 44 的幂，那么 nn 的二进制表示中有且仅有一个 11，并且这个 11 出现在从低位开始的第偶数个二进制位上（这是因为这个 11 后面必须有偶数个 00）。这里我们规定最低位为第 00 位，例如 n=16n=16 时，nn 的二进制表示为
     *
     * (10000)_2
     * (10000)
     * 2
     * ​
     *
     *
     * 唯一的 11 出现在第 44 个二进制位上，因此 nn 是 44 的幂。
     *
     * 由于题目保证了 nn 是一个 3232 位的有符号整数，因此我们可以构造一个整数 \textit{mask}mask，它的所有偶数二进制位都是 00，所有奇数二进制位都是 11。这样一来，我们将 nn 和 \textit{mask}mask 进行按位与运算，如果结果为 00，说明 nn 二进制表示中的 11 出现在偶数的位置，否则说明其出现在奇数的位置。
     *
     * 根据上面的思路，\textit{mask}mask 的二进制表示为：
     *
     * \textit{mask} = (10101010101010101010101010101010)_2
     * mask=(10101010101010101010101010101010)
     * 2
     * ​
     *
     *
     * 我们也可以将其表示成 1616 进制的形式，使其更加美观：
     *
     * \textit{mask} = (\text{AAAAAAAA})_{16}
     * mask=(AAAAAAAA)
     * 16
     * ​
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode-solution-b3ya/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
