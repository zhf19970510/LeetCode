package LeetCode2288;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeetCode2288 {

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        char[] chars = sentence.toCharArray();
        int len = chars.length;
        BigDecimal discountDecimal = new BigDecimal(String.valueOf(100 - discount)).divide(new BigDecimal("100"), 9, RoundingMode.HALF_UP);
        for(int i = 0; i < len;) {
            StringBuilder sbInner = new StringBuilder();
            boolean isNum = true;
            boolean is$Fist = chars[i] == '$';
            sb.append(chars[i]);
            i++;
            while (i < len && chars[i] != ' ') {
                sbInner.append(chars[i]);
                if(isNum && !(chars[i] >= '0' && chars[i] <= '9')) {
                    isNum = false;
                }
                i++;
            }
            if(sbInner.length() > 0) {
                if(is$Fist && isNum) {
                    sb.append(new BigDecimal(sbInner.toString()).multiply(discountDecimal).setScale(2, RoundingMode.HALF_UP).toPlainString());
                } else {
                    sb.append(sbInner);
                }
            }
            if(i < len && chars[i] == ' ') {
                sb.append(chars[i]);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        {
            LeetCode2288 leetCode2288 = new LeetCode2288();
            String sentence = "there are $1 $2 and 5$ candies in the shop";
            int discount = 50;
            System.out.println(leetCode2288.discountPrices(sentence, discount));
        }

        {
            LeetCode2288 leetCode2288 = new LeetCode2288();
            String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
            int discount = 100;
            System.out.println(leetCode2288.discountPrices(sentence, discount));
        }
    }

}
