package leetcode2806;

public class LeetCode2806 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int b = purchaseAmount / 10;
        int y = purchaseAmount % 10;
        if(y == 0) {
            return 100 - purchaseAmount;
        } else {
            if(y < 5) {
                return 100 - b * 10;
            }
            return 100 - (b + 1) * 10;
        }
    }
}
