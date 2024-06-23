package leetcode2748;

public class LeetCode2748 {
    public int countBeautifulPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = getHeightNum(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int b = getLowNum(nums[j]);
                if (gcd(a, b) == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public int getHeightNum(int num) {
        if (num < 10) {
            return num;
        }
        int temp = num / 10;
        while (temp >= 10) {
            temp = temp / 10;
        }
        return temp;
    }

    public int getLowNum(int num) {
        return num - (num / 10) * 10;
    }

    public int gcd(int x, int y) {
        int r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }

    public static void main(String[] args) {
        // 183
        LeetCode2748 leetCode2748 = new LeetCode2748();
        int[] nums = new int[]{756, 1324, 2419, 495, 106, 111, 1649, 1474, 2001, 1633, 273, 1804, 2102, 1782, 705, 1529, 1761, 1613, 111, 186, 412};
        System.out.println(nums.length);
        System.out.println(21 * 20 / 2);
        System.out.println(leetCode2748.countBeautifulPairs(nums));
    }
}
