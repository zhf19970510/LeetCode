package NC;

/**
 * 对于一个长度为 n字符串，我们需要对它做一些变形。
 * 首先这个字符串中包含着一些空格，就像"Hello Worid"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"WORLD hELLO".
 * 数据范围: 1 < n < 106,字符串中包括大写英文字母、小写英文字母、空格.进阶:空间复杂度 O(n)，时间复杂度 O(n)
 */
public class BM83 {


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @param n int整型
         * @return string字符串
         */
        public String trans (String s, int n) {
            // write code here
            char[] chs = s.toCharArray();
            int range = 'A' - 'a';
            int lastStartIndex = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < chs.length; i++) {
                if(chs[i] >= 'a' && chs[i] <= 'z') {
                    chs[i] = (char) (chs[i] + range);
                }else if(chs[i] >= 'A' && chs[i] <= 'Z'){
                    chs[i] = (char) (chs[i] - range);
                }else {
                    sb.insert(0, chs, lastStartIndex, i - lastStartIndex);
                    sb.insert(0, chs[i]);
                    lastStartIndex = i + 1;
                }

            }
            sb.insert(0, chs, lastStartIndex, chs.length - lastStartIndex);

            return sb.toString();
        }
    }
}
